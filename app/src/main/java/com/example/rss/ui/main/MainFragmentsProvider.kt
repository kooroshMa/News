package com.example.rss.ui.main

import com.example.rss.ui.favorite.FavoriteFragment
import com.example.rss.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsProvider {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment


    @ContributesAndroidInjector
    abstract fun provideFavoriteFragment(): FavoriteFragment
}