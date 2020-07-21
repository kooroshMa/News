package com.example.rss.domain.usecase

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.repository.FindFeedByIdRepository
import com.example.rss.domain.usecase.base.FlowableUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class FindJsonFeedByIdUseCase @Inject constructor(
    private val findFeedByIdRepository: FindFeedByIdRepository,
    errorUtil: DomainErrorUtil
) : FlowableUseCase<ArticleModel>(errorUtil) {

    private lateinit var id: String

    fun setParameters(id: String): FindJsonFeedByIdUseCase {
        this.id = id
        return this
    }

    override fun execute(): Flowable<ArticleModel> {
        return findFeedByIdRepository.finJsonFeedById(id)
    }
}