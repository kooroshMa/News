package com.example.rss.data.repository

import com.example.rss.data.source.db.dao.JsonFeedDao
import com.example.rss.data.source.db.dao.XmlFeedDao
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.repository.FindFeedByIdRepository
import io.reactivex.Flowable
import javax.inject.Inject

class FindFeedsByIdRepositoryImpl @Inject constructor(
    private val xmlFeedDao: XmlFeedDao,
    private val jsonFeedDao: JsonFeedDao
) : FindFeedByIdRepository {
    override fun finJsonFeedById(id: String): Flowable<FeedsModel> {
        return Flowable.fromCallable {
            jsonFeedDao.findNewsEnById(id)
        }
    }

    override fun fundXmlFeedById(id: String): Flowable<FeedsModel> {
        return Flowable.fromCallable {
            xmlFeedDao.findNewsFaById(id)
        }
    }
}