package com.example.rss.domain.repository

import com.example.rss.domain.model.FeedsModel

interface FindFeedByIdRepository {
    fun finJsonFeedById(id: String):FeedsModel

    fun fundXmlFeedById(id: String):FeedsModel
}