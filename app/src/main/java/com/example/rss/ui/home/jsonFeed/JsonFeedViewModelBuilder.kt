package com.example.rss.ui.home.jsonFeed

import androidx.lifecycle.ViewModel
import com.example.rss.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class JsonFeedViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(JsonFeedViewModel::class)
    abstract fun bindJsonFeedViewModel(jsonFeedViewModel: JsonFeedViewModel): ViewModel
}