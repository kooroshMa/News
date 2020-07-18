package com.example.rss.data.restful

import com.example.rss.domain.model.xmlFeed.XmlFeedModel
import io.reactivex.Flowable
import retrofit2.http.GET

interface APIs {

    @GET("rss/tp/10")
    fun getXmlFeeds():Flowable<XmlFeedModel>

}
