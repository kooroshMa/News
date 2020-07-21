package com.example.rss.domain.repository

import com.example.rss.domain.model.FeedsModel
import io.reactivex.Flowable

interface FindFeedByIdRepository {
    fun finJsonFeedById(id: String):Flowable<FeedsModel>

    fun fundXmlFeedById(id: String):Flowable<FeedsModel>
}