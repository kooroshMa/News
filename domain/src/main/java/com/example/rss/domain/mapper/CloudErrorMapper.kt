package com.example.rss.domain.mapper

import com.example.rss.domain.model.response.DomainErrorException

interface CloudErrorMapper {

    fun mapToDomainErrorException(throwable: Throwable?): DomainErrorException
}