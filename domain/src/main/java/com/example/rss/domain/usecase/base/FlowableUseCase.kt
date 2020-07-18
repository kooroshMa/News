package com.example.rss.domain.usecase.base

import com.example.rss.domain.mapper.DomainErrorUtil
import com.example.rss.domain.model.response.ErrorResponse
import com.example.rss.domain.model.response.SuccessResponse
import com.example.rss.domain.model.response.UseCaseResponse
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class FlowableUseCase<T>(val errorUtil: DomainErrorUtil) : UseCase<Flowable<T>>() {
    fun execute(
        compositeDisposable: CompositeDisposable,
        onResponse: (UseCaseResponse<T>) -> Unit
    ): Disposable {
        return this.execute()
            .onBackpressureLatest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onResponse(
                        SuccessResponse(
                            it
                        )
                    )
                },
                {
                    val error = errorUtil.getErrorModel(it)
                    onResponse(
                        ErrorResponse(
                            error
                        )
                    )
                }).also { compositeDisposable.add(it) }
    }
}