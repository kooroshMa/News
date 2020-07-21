package com.example.rss.domain.usecase.base

abstract class UseCase<T> {
    abstract fun execute(): T
}