package com.example.rss.data.source.cloud

import com.example.rss.domain.model.jsonFeed.JsonFeedModel
import com.example.rss.domain.model.xmlFeed.XmlFeedModel
import com.google.gson.Gson
import io.reactivex.Flowable

class CloudMockRepository(private val gson: Gson) : BaseCloudRepository {

    override fun getXmlFeed(): Flowable<XmlFeedModel> {
        TODO("Not yet implemented")
    }

    override fun getJsonFeed(sources: String, apiKey: String): Flowable<JsonFeedModel> {
        TODO("Not yet implemented")
    }


}