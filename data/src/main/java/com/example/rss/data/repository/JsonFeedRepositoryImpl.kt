package com.example.rss.data.repository

import com.example.rss.data.di.Cloud
import com.example.rss.data.source.cloud.BaseCloudRepository
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.repository.JsonFeedRepository
import io.reactivex.Flowable
import javax.inject.Inject

class JsonFeedRepositoryImpl @Inject constructor(
    @Cloud private val cloudRepository: BaseCloudRepository
) : JsonFeedRepository {

    override fun getJsonFeed(sources: String, apiKey: String): Flowable<List<ArticleModel>> {
        return cloudRepository.getJsonFeed(sources, apiKey).map { it.articles }
    }

}