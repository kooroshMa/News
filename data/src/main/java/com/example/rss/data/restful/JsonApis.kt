package com.example.rss.data.restful

import com.example.rss.domain.model.jsonFeed.JsonFeedModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonApis {

    @GET("top-headlines")
    fun getJsonFeed(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String):Flowable<JsonFeedModel>
}