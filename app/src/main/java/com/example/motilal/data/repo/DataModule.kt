package com.example.motilal.data.repo

import android.app.Application
import android.app.job.JobService
import com.example.motilal.data.db.AppDatabase
import com.example.motilal.data.db.AppDbModule
import com.example.motilal.data.network.NetworkModule
import com.example.motilal.data.network.Routes
import com.example.motilal.di.AppModule
import com.example.motilal.di.scope.AppScope

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule::class, NetworkModule::class, AppDbModule::class])
class DataModule {
    @Singleton
    @Provides
    fun provideAppDataRepository(
        app: Application,
        apiService: Routes,
        localDatabase: AppDatabase
    ): DataRepository = AppDataRepository(app, apiService, localDatabase)


}