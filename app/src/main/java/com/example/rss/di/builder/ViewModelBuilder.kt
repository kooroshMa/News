package com.example.rss.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import com.example.rss.di.viewmodel.RssViewModelFactory

@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(rssViewModelFactory: RssViewModelFactory): ViewModelProvider.Factory
}