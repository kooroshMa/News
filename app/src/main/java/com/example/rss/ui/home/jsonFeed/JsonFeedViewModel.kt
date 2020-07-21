package com.example.rss.ui.home.jsonFeed

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.example.rss.base.BaseViewModel
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.response.ErrorResponse
import com.example.rss.domain.model.response.SuccessResponse
import com.example.rss.domain.model.response.UseCaseResponse
import com.example.rss.domain.usecase.jsonFeed.JsonFeedFavoriteUseCase
import com.example.rss.domain.usecase.jsonFeed.JsonFeedUnFavoriteUseCase
import com.example.rss.domain.usecase.jsonFeed.JsonFeedUseCase
import javax.inject.Inject

class JsonFeedViewModel @Inject constructor(
    val navigator: JsonFeedNavigator,
    private val jsonFeedUseCase: JsonFeedUseCase,
    private val jsonFeedFavoriteUseCase: JsonFeedFavoriteUseCase,
    private val jsonFeedUnFavoriteUseCase: JsonFeedUnFavoriteUseCase
) : BaseViewModel() {

    val jsonFeedLiveData = MutableLiveData<List<ArticleModel>>()

    companion object{
        private const val SOURCE = "techcrunch"
        private const val API_KEY = "95a7a91b22f74929b6159a2a4ea22cee"
    }

    private var jsonFeed: Unit? = null

    override fun onResume() {
        super.onResume()

        if (jsonFeed == null){
            jsonFeed = getJsonFeed()
        }
    }

    private fun getJsonFeed() {
        jsonFeedUseCase.setParameters(SOURCE, API_KEY)
            .execute(this.compositeDisposable, this::onGetJsonFeedResult)
    }

    @VisibleForTesting
    fun onGetJsonFeedResult(response: UseCaseResponse<List<ArticleModel>>) {
        when (response) {
            is SuccessResponse -> {
                jsonFeedLiveData.value = response.value
            }
            is ErrorResponse -> {
            }
        }
    }

    fun favoriteJsonFeed(articleModel: ArticleModel){
        jsonFeedFavoriteUseCase.setParameters(articleModel).execute(
            this.compositeDisposable, this::onFavoriteResponse)
    }

    private fun onFavoriteResponse(response: UseCaseResponse<Unit>) {
    }

    fun unFavoriteJsonFeed(articleModel: ArticleModel){
        jsonFeedUnFavoriteUseCase.setParameters(articleModel).execute(
            this.compositeDisposable, this::onFavoriteResponse)
    }
}