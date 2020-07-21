package com.example.rss.data.source.cloud

import com.example.rss.domain.model.jsonFeed.JsonFeedModel
import com.example.rss.domain.model.xmlFeed.XmlFeedModel
import io.reactivex.Flowable


interface BaseCloudRepository {

    fun getXmlFeed(): Flowable<XmlFeedModel>

    fun getJsonFeed(sources:String, apiKey:String ): Flowable<JsonFeedModel>
}