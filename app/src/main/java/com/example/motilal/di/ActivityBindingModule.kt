package com.example.motilal.di

import com.example.motilal.ui.activitys.main.MainActivity
import com.example.motilal.ui.activitys.main.MainViewModelModule
import com.example.motilal.ui.fragments.dashboard.DashboardModule
import com.example.motilal.ui.fragments.detailview.DetailFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("UNUSED")
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainViewModelModule::class,
            DashboardModule::class,
            DetailFragmentModule::class
        ]
    )

    abstract fun contributeMainActivity(): MainActivity


}
