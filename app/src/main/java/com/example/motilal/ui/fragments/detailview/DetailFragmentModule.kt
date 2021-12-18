package com.example.motilal.ui.fragments.detailview

import androidx.lifecycle.ViewModel
import com.example.motilal.di.scope.FragmentScope
import com.example.motilal.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DetailFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeDetailFragment(): DetailFragment


    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

}