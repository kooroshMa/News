package com.example.rss.domain.usecase.jsonFeed

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.repository.jsonFeed.JsonFeedFavoriteRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class JsonFeedUnFavoriteUseCase @Inject constructor(
    errorUtil: DomainErrorUtil,
    private val jsonFeedFavoriteRepository: JsonFeedFavoriteRepository
) : FlowableUseCase<Unit>(errorUtil) {

    private lateinit var articleModel: ArticleModel

    fun setParameters(articleModel: ArticleModel): JsonFeedUnFavoriteUseCase {
        this.articleModel = articleModel
        return this
    }

    override fun execute(): Flowable<Unit> {
        return jsonFeedFavoriteRepository.unFavoriteJsonFeed(articleModel)
    }

}