package com.example.rss.domain.repository.xmlFeed

import com.example.rss.domain.model.xmlFeed.DetailModel
import io.reactivex.Flowable

interface XmlFeedFavoriteRepository {

    fun favoriteXmlFeed(detailModel: DetailModel): Flowable<Unit>

    fun unFavoriteXmlFeed(detailModel: DetailModel): Flowable<Unit>

}