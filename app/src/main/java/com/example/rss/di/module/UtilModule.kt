package com.example.rss.di.module

import dagger.Binds
import dagger.Module
import com.example.rss.util.connectivity.BaseConnectionManager
import com.example.rss.util.connectivity.ConnectionManager
import com.example.rss.util.providers.BaseResourceProvider
import com.example.rss.util.providers.ResourceProvider
import javax.inject.Singleton

@Module
interface UtilModule {

    @Binds
    @Singleton
    fun bindConnectionManager(connectionManager: ConnectionManager): BaseConnectionManager

    @Binds
    fun bindResourceProvider(resourceProvider: ResourceProvider): BaseResourceProvider
}