package com.example.rss.domain.mapper

import com.example.rss.domain.model.response.ErrorModel
import com.example.rss.domain.model.response.ErrorStatus
import javax.inject.Inject

class DomainErrorUtil @Inject constructor(private val cloudErrorMapper: CloudErrorMapper) {

    fun getErrorModel(t: Throwable?): ErrorModel {
        if (t is NullPointerException) {
            return ErrorModel(
                ErrorStatus.EMPTY_RESPONSE
            )
        }

        return cloudErrorMapper.mapToDomainErrorException(t).errorModel
    }
}

