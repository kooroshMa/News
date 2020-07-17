package com.example.rss.ui.home.xmlFeed

import androidx.lifecycle.ViewModel
import com.example.rss.di.viewmodel.ViewModelKey
import com.example.rss.ui.home.jsonFeed.JsonFeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class XmlFeedViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(XmlFeedViewModel::class)
    abstract fun bindXmlFeedViewModel(xmlFeedViewModel: XmlFeedViewModel): ViewModel
}