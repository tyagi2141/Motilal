package com.example.motilal.ui.activitys.main

import androidx.lifecycle.ViewModel
import com.example.motilal.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Rahul on 16/12/21.
 */
@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainViewModel): ViewModel
}