package com.example.motilal.data.db

import android.app.Application
import androidx.room.Room
import com.example.motilal.di.AppModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [AppModule::class])
class AppDbModule {
    @Singleton
    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "app.db").allowMainThreadQueries().build();

}