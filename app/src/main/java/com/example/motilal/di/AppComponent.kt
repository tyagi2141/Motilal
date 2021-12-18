package com.example.motilal.di

import com.example.motilal.AppApplication
import com.example.motilal.data.db.AppDbModule
import com.example.motilal.data.network.NetworkModule
import com.example.motilal.data.repo.DataModule
import com.example.motilal.data.works.WorkersModule

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Rahul on 16/12/21.
 */

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        AppDbModule::class,
        DataModule::class,
        ViewModelFactoryModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        WorkersModule::class

    ]
)
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Factory
    interface Factory {
        fun create(appModule: AppModule): AppComponent

    }

}


/*
@Component(modules = [ServiceModule::class])
internal interface MyServiceComponent {
    fun inject(service: JobSchedulerService?)
}*/
