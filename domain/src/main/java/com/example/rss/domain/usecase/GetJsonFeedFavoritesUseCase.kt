package com.example.rss.domain.usecase

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.repository.GetAllFavoriteFeedRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetJsonFeedFavoritesUseCase @Inject constructor(
    errorUtil: DomainErrorUtil,
    private val getAllFavoriteFeedRepository: GetAllFavoriteFeedRepository
) : FlowableUseCase<List<ArticleModel>>(errorUtil) {
    override fun execute(): Flowable<List<ArticleModel>> {
        return getAllFavoriteFeedRepository.getAllJsonFeedFavorites()
    }
}