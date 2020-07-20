package com.example.rss.data.repository

import com.example.rss.data.source.db.dao.JsonFeedDao
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.repository.jsonFeed.JsonFeedFavoriteRepository
import io.reactivex.Flowable
import javax.inject.Inject

class JsonFeedFavoriteRepositoryImpl  @Inject constructor(
    private val jsonFeedDao: JsonFeedDao
) : JsonFeedFavoriteRepository {

    override fun favoriteJsonFeed(articleModel: ArticleModel):Flowable<Unit> {
        return Flowable.fromCallable{ jsonFeedDao.favoriteJsonFeed(articleModel.link) }
    }

    override fun unFavoriteJsonFeed(articleModel: ArticleModel): Flowable<Unit> {
        return Flowable.fromCallable { jsonFeedDao.unFavoriteJsonFeed(articleModel.link) }
    }
}