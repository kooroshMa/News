package com.example.rss.data.repository.xmlFeed

import com.example.rss.data.di.Cloud
import com.example.rss.data.source.cloud.BaseCloudRepository
import com.example.rss.data.source.db.dao.XmlFeedDao
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.repository.xmlFeed.XmlFeedRepository
import io.reactivex.Flowable
import javax.inject.Inject

class XmlFeedRepositoryImpl @Inject constructor(
    @Cloud private val cloudRepository: BaseCloudRepository,
    private val xmlFeedDao: XmlFeedDao
) : XmlFeedRepository {

    override fun getXmlFeed(): Flowable<List<DetailModel>> {
        return Flowable.fromCallable { xmlFeedDao.getCount() }
            .flatMap {
                if (it == 0)
                // nothing exists on database, so get them from cloud
                    getXmlFeedFromCloud().flatMap {
                        xmlFeedDao.getXmlFeed()
                    }
                else
                // there are some movies in db, so attempt to get them and update db
                Flowable.concatArrayEager(xmlFeedDao.getXmlFeed(), getXmlFeedFromCloud())
            }
    }


    private fun getXmlFeedFromCloud(): Flowable<List<DetailModel>> {
        return cloudRepository
            .getXmlFeed().map {
                it.channel?.details
            }.map(this::insertXmlFeedToDb)

    }

    /**
     * Attempts to insert fetched xmlFeed to database and returns the given list
     */
    private fun insertXmlFeedToDb(xmlFeeds: List<DetailModel>): List<DetailModel> {
        xmlFeedDao.insertXmlFeed(xmlFeeds)
        return xmlFeeds
    }

}