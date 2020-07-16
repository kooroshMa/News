package com.example.rss.di.module

import android.content.Context
import com.example.rss.app.RSSApplication
import com.example.rss.di.builder.RepositoryBuilder
import dagger.Module
import dagger.Provides
import com.example.rss.di.builder.ViewModelBuilder
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class, RepositoryBuilder::class])
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: RSSApplication): Context {
        return application
    }
}
