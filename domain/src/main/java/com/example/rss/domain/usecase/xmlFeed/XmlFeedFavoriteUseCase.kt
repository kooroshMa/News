package com.example.rss.domain.usecase.xmlFeed

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.repository.xmlFeed.XmlFeedFavoriteRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class XmlFeedFavoriteUseCase @Inject constructor(
    errorUtil: DomainErrorUtil,
    private val xmlFeedFavoriteRepository: XmlFeedFavoriteRepository
) : FlowableUseCase<Unit>(errorUtil) {

    private lateinit var detailModel: DetailModel

    fun setParameters(detailModel: DetailModel): XmlFeedFavoriteUseCase {
        this.detailModel = detailModel
        return this
    }

    override fun execute(): Flowable<Unit> {
        return xmlFeedFavoriteRepository.favoriteXmlFeed(detailModel)
    }
}