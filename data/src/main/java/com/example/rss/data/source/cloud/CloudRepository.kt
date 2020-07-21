package com.example.rss.data.source.cloud

import com.example.rss.data.restful.APIs
import com.example.rss.data.restful.JsonApis
import com.example.rss.domain.model.jsonFeed.JsonFeedModel
import com.example.rss.domain.model.xmlFeed.XmlFeedModel
import io.reactivex.Flowable


class CloudRepository(
    private val xmlFeedApi: APIs,
    private val jsonFeedApi: JsonApis
) : BaseCloudRepository {

    override fun getXmlFeed(): Flowable<XmlFeedModel> {
        return xmlFeedApi.getXmlFeeds()
    }

    override fun getJsonFeed(sources: String, apiKey: String): Flowable<JsonFeedModel> {
        return jsonFeedApi.getJsonFeed(sources,apiKey)
    }


}