package com.example.rss.ui.favorite

import androidx.lifecycle.MutableLiveData
import com.example.rss.base.BaseViewModel
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.response.ErrorResponse
import com.example.rss.domain.model.response.SuccessResponse
import com.example.rss.domain.model.response.UseCaseResponse
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.usecase.GetXmlFeedFavoriteUseCase
import com.example.rss.domain.usecase.GetJsonFeedFavoritesUseCase
import com.example.rss.domain.usecase.jsonFeed.JsonFeedUnFavoriteUseCase
import com.example.rss.domain.usecase.xmlFeed.XmlFeedUnFavoriteUseCase
import com.example.rss.util.combine
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    val navigator: FavoriteNavigator,
    private val xmlFeedFavoriteUseCase: GetXmlFeedFavoriteUseCase,
    private val jsonFeedFavoritesUseCase: GetJsonFeedFavoritesUseCase,
    private val jsonFeedUnFavoriteUseCase: JsonFeedUnFavoriteUseCase,
    private val xmlFeedUnFavoriteUseCase: XmlFeedUnFavoriteUseCase
) :
    BaseViewModel() {

    private val jsonFavoriteLiveData = MutableLiveData<List<ArticleModel>>()
    private val xmlFavoriteLiveData = MutableLiveData<List<DetailModel>>()

    override fun onCreate() {
        super.onCreate()
        favoriteXmlFeed()
        getJsonFeedFavorite()
    }

    private fun getJsonFeedFavorite(){
        jsonFeedFavoritesUseCase.execute(
            this.compositeDisposable, this::onGetJsonFeedFavorite)
    }
    private fun onGetJsonFeedFavorite(response: UseCaseResponse<List<ArticleModel>>) {
        when (response) {
            is SuccessResponse -> {
                jsonFavoriteLiveData.value = response.value
            }
            is ErrorResponse -> {

            }
        }
    }

    private fun favoriteXmlFeed(){
        xmlFeedFavoriteUseCase.execute(
            this.compositeDisposable, this::onFavoriteResponse)
    }

    private fun onFavoriteResponse(response: UseCaseResponse<List<DetailModel>>) {
        when (response) {
            is SuccessResponse -> {
                xmlFavoriteLiveData.value = response.value
            }
            is ErrorResponse -> {

            }
        }
    }

    private fun onUnFavoriteResponse(response: UseCaseResponse<Unit>) {
    }

    fun unFavoriteJsonFeed(articleModel: ArticleModel){
        jsonFeedUnFavoriteUseCase.setParameters(articleModel).execute(
            this.compositeDisposable, this::onUnFavoriteResponse)
    }
    fun unFavoriteXmlFeed(detailModel: DetailModel){
        xmlFeedUnFavoriteUseCase.setParameters(detailModel).execute(
            this.compositeDisposable, this::onUnFavoriteResponse)
    }

    fun combineLiveData(): MutableLiveData<List<FeedsModel>> =
        combine(jsonFavoriteLiveData,xmlFavoriteLiveData ) { news_en, news_fa ->
            val list = mutableListOf<FeedsModel>()
            news_en?.let { list.addAll(it) }
            news_fa?.let { list.addAll(it) }
            return@combine list.toList()
    }
}