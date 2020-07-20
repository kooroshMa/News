package com.example.rss.di.builder

import com.example.rss.data.mapper.CloudErrorMapperImpl
import com.example.rss.data.repository.JsonFeedFavoriteRepositoryImpl
import com.example.rss.data.repository.JsonFeedRepositoryImpl
import com.example.rss.data.repository.XmlFeedRepositoryImpl
import com.example.rss.domain.mapper.CloudErrorMapper
import com.example.rss.domain.repository.jsonFeed.JsonFeedFavoriteRepository
import com.example.rss.domain.repository.jsonFeed.JsonFeedRepository
import com.example.rss.domain.repository.xmlFeed.XmlFeedRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {

    @Binds
    abstract fun bindsCloudErrorMapper(cloudErrorMapperImpl: CloudErrorMapperImpl): CloudErrorMapper

    @Binds
    abstract fun bindXmlFeedRepository(xmlFeedRepositoryImpl: XmlFeedRepositoryImpl): XmlFeedRepository

    @Binds
    abstract fun bindJsonFeedRepository(jsonFeedRepositoryImpl: JsonFeedRepositoryImpl): JsonFeedRepository

    @Binds
    abstract fun bindJsonFeedFavoriteRepository(jsonFeedFavoriteRepositoryImpl: JsonFeedFavoriteRepositoryImpl):JsonFeedFavoriteRepository

}