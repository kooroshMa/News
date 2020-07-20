package com.example.rss.domain.usecase

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.repository.GetAllFavoriteFeedRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetAllFavoriteUseCase @Inject constructor(
    errorUtil: DomainErrorUtil,
    private val getAllFavoriteFeedRepository: GetAllFavoriteFeedRepository
) : FlowableUseCase<List<FeedsModel>>(errorUtil) {

    override fun execute(): Flowable<List<FeedsModel>> {
        return getAllFavoriteFeedRepository.getAllXmlFeedFavorites().flatMap {
            Flowable.fromCallable { it as List<FeedsModel> }
        }.mergeWith(getAllFavoriteFeedRepository.getAllJsonFeedFavorites())
    }

}