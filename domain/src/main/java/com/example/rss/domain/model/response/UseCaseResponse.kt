package com.example.rss.domain.model.response

sealed class UseCaseResponse<out T>

data class SuccessResponse<out T>(val value: T) : UseCaseResponse<T>()

data class ErrorResponse<out T>(val error: ErrorModel) : UseCaseResponse<T>()