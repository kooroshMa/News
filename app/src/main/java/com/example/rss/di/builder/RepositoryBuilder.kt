package com.example.rss.di.builder

import com.example.rss.data.mapper.CloudErrorMapperImpl
import com.example.rss.data.repository.XmlFeedRepositoryImpl
import com.example.rss.domain.mapper.CloudErrorMapper
import com.example.rss.domain.repository.XmlFeedRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {

    @Binds
    abstract fun bindsCloudErrorMapper(cloudErrorMapperImpl: CloudErrorMapperImpl): CloudErrorMapper

    @Binds
    abstract fun bindXmlFeedRepository(xmlFeedRepositoryImpl: XmlFeedRepositoryImpl):XmlFeedRepository

}