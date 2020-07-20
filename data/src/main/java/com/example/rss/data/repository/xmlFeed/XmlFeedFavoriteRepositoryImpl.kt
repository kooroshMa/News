package com.example.rss.data.repository.xmlFeed

import com.example.rss.data.source.db.dao.XmlFeedDao
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.repository.xmlFeed.XmlFeedFavoriteRepository
import io.reactivex.Flowable
import javax.inject.Inject

class XmlFeedFavoriteRepositoryImpl @Inject constructor(
    private val xmlFeedDao: XmlFeedDao
) : XmlFeedFavoriteRepository {

    override fun favoriteXmlFeed(detailModel: DetailModel): Flowable<Unit> {
        return Flowable.fromCallable{ xmlFeedDao.favoriteXmlFeed(detailModel.guid) }
    }

    override fun unFavoriteXmlFeed(detailModel: DetailModel): Flowable<Unit> {
        return Flowable.fromCallable{ xmlFeedDao.unFavoriteXmlFeed(detailModel.guid) }
    }
}