package com.example.motilal.ui.fragments.dashboard

import androidx.lifecycle.ViewModel
import com.example.motilal.di.scope.FragmentScope
import com.example.motilal.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DashboardModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeDashboardFragment(): DashboardFragment


    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(viewModel: DashboardViewModel): ViewModel

}