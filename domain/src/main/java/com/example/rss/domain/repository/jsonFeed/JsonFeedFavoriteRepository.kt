package com.example.rss.domain.repository.jsonFeed

import com.example.rss.domain.model.jsonFeed.ArticleModel
import io.reactivex.Flowable

interface JsonFeedFavoriteRepository {

    fun favoriteJsonFeed(articleModel: ArticleModel):Flowable<Unit>

    fun unFavoriteJsonFeed(articleModel: ArticleModel):Flowable<Unit>

}