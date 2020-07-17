package com.example.rss.di.builder

import com.example.rss.ui.main.MainActivity
import com.example.rss.ui.main.MainFragmentsProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainFragmentsProvider::class])
    internal abstract fun bindMainActivity(): MainActivity
}
