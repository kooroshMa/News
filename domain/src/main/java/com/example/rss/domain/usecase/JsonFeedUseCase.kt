package com.example.rss.domain.usecase

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.repository.JsonFeedRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class JsonFeedUseCase @Inject constructor(
    errorUtil: DomainErrorUtil,
    private val jsonFeedRepository: JsonFeedRepository
) : FlowableUseCase<List<ArticleModel>>(errorUtil) {

    private lateinit var sources: String
    private lateinit var apiKey: String

    fun setParameters(sources: String, apiKey: String): JsonFeedUseCase {
        this.sources = sources
        this.apiKey = apiKey
        return this
    }

    override fun execute(): Flowable<List<ArticleModel>> {
        return jsonFeedRepository.getJsonFeed(sources,apiKey)
    }

}