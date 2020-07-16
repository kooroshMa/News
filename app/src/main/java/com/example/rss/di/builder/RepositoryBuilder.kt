package com.example.rss.di.builder

import com.example.rss.data.mapper.CloudErrorMapperImpl
import com.example.rss.domain.mapper.CloudErrorMapper
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {

    @Binds
    abstract fun bindsCloudErrorMapper(cloudErrorMapperImpl: CloudErrorMapperImpl): CloudErrorMapper

}