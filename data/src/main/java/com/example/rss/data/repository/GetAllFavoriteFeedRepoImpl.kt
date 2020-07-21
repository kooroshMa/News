package com.example.rss.data.repository

import com.example.rss.data.source.db.dao.JsonFeedDao
import com.example.rss.data.source.db.dao.XmlFeedDao
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.repository.GetAllFavoriteFeedRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetAllFavoriteFeedRepoImpl @Inject constructor(
    private val xmlFeedDao: XmlFeedDao,
    private val jsonFeedDao: JsonFeedDao
) : GetAllFavoriteFeedRepository {

    override fun getAllXmlFeedFavorites(): Flowable<List<DetailModel>> {
        return xmlFeedDao.getFavoriteXmlFeed()
    }

    override fun getAllJsonFeedFavorites(): Flowable<List<ArticleModel>> {
        return jsonFeedDao.getFavoriteJsonFeed()
    }
}