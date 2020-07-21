package com.example.rss.domain.usecase

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.repository.GetAllFavoriteFeedRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetXmlFeedFavoriteUseCase @Inject constructor(
    errorUtil: DomainErrorUtil,
    private val getAllFavoriteFeedRepository: GetAllFavoriteFeedRepository
) : FlowableUseCase<List<DetailModel>>(errorUtil) {

    override fun execute(): Flowable<List<DetailModel>> {
        return getAllFavoriteFeedRepository.getAllXmlFeedFavorites()


    }
}