package com.example.rss.ui.main

import com.example.rss.ui.favorite.FavoriteFragment
import com.example.rss.ui.home.HomeFragment
import com.example.rss.ui.home.HomeFragmentsProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsProvider {

    @ContributesAndroidInjector(modules = [HomeFragmentsProvider::class])
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun provideFavoriteFragment(): FavoriteFragment
}