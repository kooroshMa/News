package com.example.rss.data.repository

import com.example.rss.data.di.Cloud
import com.example.rss.data.source.cloud.BaseCloudRepository
import com.example.rss.domain.model.xmlFeed.XmlFeedModel
import com.example.rss.domain.repository.XmlFeedRepository
import io.reactivex.Flowable
import javax.inject.Inject

class XmlFeedRepositoryImpl @Inject constructor(
    @Cloud private val cloudRepository: BaseCloudRepository
) : XmlFeedRepository {

    override fun getXmlFeed(): Flowable<XmlFeedModel> {
        return cloudRepository.getXmlFeed()
    }

}