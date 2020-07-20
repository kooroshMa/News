package com.example.rss.ui.favorite

import com.example.rss.base.BaseViewModel
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.model.response.ErrorResponse
import com.example.rss.domain.model.response.SuccessResponse
import com.example.rss.domain.model.response.UseCaseResponse
import com.example.rss.domain.usecase.GetAllFavoriteUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    val navigator: FavoriteNavigator,
    private val favoriteUseCase: GetAllFavoriteUseCase
) :
    BaseViewModel() {

    override fun onCreate() {
        super.onCreate()
        unFavoriteJsonFeed()
    }

    private fun unFavoriteJsonFeed(){
        favoriteUseCase.execute(
            this.compositeDisposable, this::onFavoriteResponse)
    }

    private fun onFavoriteResponse(response: UseCaseResponse<List<FeedsModel>>) {
        when (response) {
            is SuccessResponse -> {
            }
            is ErrorResponse -> {

            }
        }
    }
}