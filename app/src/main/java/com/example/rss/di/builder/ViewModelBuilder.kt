package com.example.rss.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import com.example.rss.di.viewmodel.RssViewModelFactory
import com.example.rss.ui.detail.DetailViewModelBuilder
import com.example.rss.ui.main.MainViewModelBuilder

@Module(includes = [MainViewModelBuilder::class, DetailViewModelBuilder::class])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(rssViewModelFactory: RssViewModelFactory): ViewModelProvider.Factory
}