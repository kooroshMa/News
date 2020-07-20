package com.example.rss.di.builder

import com.example.rss.data.mapper.CloudErrorMapperImpl
import com.example.rss.data.repository.GetAllFavoriteFeedRepoImpl
import com.example.rss.data.repository.jsonFeed.JsonFeedFavoriteRepositoryImpl
import com.example.rss.data.repository.jsonFeed.JsonFeedRepositoryImpl
import com.example.rss.data.repository.xmlFeed.XmlFeedFavoriteRepositoryImpl
import com.example.rss.data.repository.xmlFeed.XmlFeedRepositoryImpl
import com.example.rss.domain.mapper.CloudErrorMapper
import com.example.rss.domain.repository.jsonFeed.JsonFeedFavoriteRepository
import com.example.rss.domain.repository.jsonFeed.JsonFeedRepository
import com.example.rss.domain.repository.GetAllFavoriteFeedRepository
import com.example.rss.domain.repository.xmlFeed.XmlFeedFavoriteRepository
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

    @Binds
    abstract fun bindXmlFeedFavoriteRepository(xmlFeedFavoriteRepositoryImpl: XmlFeedFavoriteRepositoryImpl):XmlFeedFavoriteRepository

    @Binds
    abstract fun bindGetAllFavoriteFeedRepo(getAllFavoriteFeedRepoImpl: GetAllFavoriteFeedRepoImpl): GetAllFavoriteFeedRepository

}