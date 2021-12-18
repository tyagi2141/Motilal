package com.example.motilal.di

import android.app.Application
import com.example.motilal.di.scope.AppScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Rahul on 16/12/21.
 */
@Module
class AppModule @Inject constructor(var application: Application) {

    @Singleton
    @Provides
    fun provideApp(): Application = application


    @Singleton
    @Provides
    @Named("app")
    fun provideGson() = Gson()
}
