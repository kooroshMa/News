package com.example.rss.domain.repository

import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.xmlFeed.DetailModel
import io.reactivex.Flowable

interface FindFeedByIdRepository {
    fun finJsonFeedById(id: String):Flowable<ArticleModel>

    fun fundXmlFeedById(id: String):Flowable<DetailModel>
}