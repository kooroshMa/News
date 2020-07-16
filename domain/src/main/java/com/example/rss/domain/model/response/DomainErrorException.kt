package com.example.rss.domain.model.response

class DomainErrorException(val errorModel: ErrorModel) : Throwable() {
}