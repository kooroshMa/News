package com.example.rss.domain.repository

import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.xmlFeed.DetailModel
import io.reactivex.Flowable

interface GetAllFavoriteFeedRepository {
    fun getAllXmlFeedFavorites(): Flowable<List<DetailModel>>

    fun getAllJsonFeedFavorites(): Flowable<List<ArticleModel>>
}