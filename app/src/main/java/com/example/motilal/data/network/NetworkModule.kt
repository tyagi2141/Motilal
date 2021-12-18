package com.example.motilal.data.network

import android.app.Application
import android.app.job.JobService
import android.util.Log
import com.example.motilal.constant.Constants
import com.example.motilal.di.AppModule

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Rahul on 16/12/21.
 */
@Module(includes = [AppModule::class])
open class NetworkModule {
    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @Named("HttpLoggingInterceptor") loggingInterceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

    @Singleton
    @Provides
    @Named("OkHttpHelper")
    fun okHttpHelperClient(
        gson: Gson
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()



    @Singleton
    @Provides
    fun RxJava2CallAdapterFactory() = RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    @Named("HttpLoggingInterceptor")
    fun provideHttpLoggingInterceptor(app: Application): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.e("OKHttp","${message}")
            }
        })

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        loggingInterceptor.redactHeader("Authorization")
        return loggingInterceptor
    }

    @Singleton
    @Provides
    @Named("RealRetrofit")
    fun getClient(
        @Named("OkHttpHelper") retrofit: Retrofit,
        okHttpClient: OkHttpClient,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit =
        retrofit.newBuilder()

            .client(okHttpClient)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()


    @Singleton
    @Provides
    fun provideApiService(@Named("RealRetrofit") retrofit: Retrofit): Routes =
        retrofit.create(Routes::class.java)


}