package com.example.rss.ui.home

import com.example.rss.ui.home.jsonFeed.JsonFeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentsProvider {

    @ContributesAndroidInjector
    abstract fun provideJsonFeedFragment(): JsonFeedFragment
}