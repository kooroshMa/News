package com.example.rss.domain.usecase.xmlFeed

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.repository.xmlFeed.XmlFeedRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class XmlFeedUseCase @Inject constructor(
    errorUtil: DomainErrorUtil,
    private val xmlFeedRepository: XmlFeedRepository
) : FlowableUseCase<List<DetailModel>>(errorUtil) {

    override fun execute(): Flowable<List<DetailModel>> {
        return xmlFeedRepository.getXmlFeed()
    }
}