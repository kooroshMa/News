package com.example.rss.ui.main

import androidx.lifecycle.ViewModel
import com.example.rss.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(maniViewModel: MainViewModel): ViewModel
}