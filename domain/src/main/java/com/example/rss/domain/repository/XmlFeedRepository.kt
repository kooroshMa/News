package com.example.rss.domain.repository

import com.example.rss.domain.model.xmlFeed.XmlFeedModel
import io.reactivex.Flowable

interface XmlFeedRepository {

    fun getXmlFeed(): Flowable<XmlFeedModel>

}