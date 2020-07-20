package com.example.rss.data.repository

import com.example.rss.data.di.Cloud
import com.example.rss.data.source.cloud.BaseCloudRepository
import com.example.rss.data.source.db.dao.JsonFeedDao
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.repository.jsonFeed.JsonFeedRepository
import io.reactivex.Flowable
import javax.inject.Inject

class JsonFeedRepositoryImpl @Inject constructor(
    @Cloud private val cloudRepository: BaseCloudRepository,
    private val jasonFeedDao: JsonFeedDao
) : JsonFeedRepository {

    override fun getJsonFeed(sources: String, apiKey: String): Flowable<List<ArticleModel>> {
        return Flowable.fromCallable { jasonFeedDao.getCount() }
            .flatMap {
                if (it == 0)
                // nothing exists on database, so get them from cloud
                    getJsonFeedFromCloud(sources, apiKey).flatMap {
                        jasonFeedDao.getJsonFeed()
                    }
                else
                // there are some movies in db, so attempt to get them
                    jasonFeedDao.getJsonFeed().also {
                        getJsonFeedFromCloud(sources, apiKey)
                    }
            }
    }

    private fun getJsonFeedFromCloud(sources: String, apiKey: String): Flowable<List<ArticleModel>> {
        return cloudRepository
            .getJsonFeed(sources,apiKey).map {
                it.articles
            }.map(this::insertToJsonFeedDb)
    }

    /**
     * Attempts to insert fetched jsonFeed to database and returns the given list
     */
    private fun insertToJsonFeedDb(jsonFeed: List<ArticleModel>): List<ArticleModel> {
        jasonFeedDao.insertJsonFeed(jsonFeed)
        return jsonFeed
    }

}