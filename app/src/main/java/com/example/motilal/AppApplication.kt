package com.example.motilal

import android.app.Activity
import android.app.Service
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.motilal.data.works.WorkerInjectorFactory
import com.example.motilal.di.AppComponent
import com.example.motilal.di.AppModule
import com.example.motilal.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Rahul on 18/12/21.
 */
class AppApplication :DaggerApplication()  {

    private lateinit var component: AppComponent

    @Inject
    lateinit var workerInjectorFactory: WorkerInjectorFactory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }




    override fun onCreate() {


        component = DaggerAppComponent.factory().create(AppModule(this))
        component.inject(this)
        super.onCreate()

        configureWorkerWithDagger()
    }

    private fun configureWorkerWithDagger() {

        val config = Configuration.Builder()
            .setWorkerFactory(workerInjectorFactory)
            .build()
        WorkManager.initialize(this, config)
    }
}