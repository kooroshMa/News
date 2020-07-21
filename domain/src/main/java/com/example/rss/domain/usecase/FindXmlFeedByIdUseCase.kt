package com.example.rss.domain.usecase

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.repository.FindFeedByIdRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class FindXmlFeedByIdUseCase @Inject constructor(
    private val findFeedByIdRepository: FindFeedByIdRepository,
    errorUtil: DomainErrorUtil
    ) : FlowableUseCase<FeedsModel>(errorUtil) {

    private lateinit var id: String

    fun setParameters(id: String): FindXmlFeedByIdUseCase {
        this.id = id
        return this
    }
    override fun execute(): Flowable<FeedsModel> {
        return findFeedByIdRepository.fundXmlFeedById(id)
    }
}