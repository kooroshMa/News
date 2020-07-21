package com.example.rss.domain.usecase

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.repository.FindFeedByIdRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class FindXmlFeedByIdUseCase @Inject constructor(
    private val findFeedByIdRepository: FindFeedByIdRepository,
    errorUtil: DomainErrorUtil
    ) : FlowableUseCase<DetailModel>(errorUtil) {

    private lateinit var id: String

    fun setParameters(id: String): FindXmlFeedByIdUseCase {
        this.id = id
        return this
    }
    override fun execute(): Flowable<DetailModel> {
        return findFeedByIdRepository.fundXmlFeedById(id)
    }
}