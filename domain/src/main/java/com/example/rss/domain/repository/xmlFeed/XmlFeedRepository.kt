package com.example.rss.domain.repository.xmlFeed

import com.example.rss.domain.model.xmlFeed.DetailModel
import io.reactivex.Flowable

interface XmlFeedRepository {

    fun getXmlFeed(): Flowable<List<DetailModel>>

}