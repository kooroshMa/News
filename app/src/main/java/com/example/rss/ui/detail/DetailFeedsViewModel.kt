package com.example.rss.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.rss.base.BaseViewModel
import com.example.rss.domain.model.FeedsModel
import com.example.rss.domain.model.FeedsType
import com.example.rss.domain.model.jsonFeed.ArticleModel
import com.example.rss.domain.model.response.ErrorResponse
import com.example.rss.domain.model.response.SuccessResponse
import com.example.rss.domain.model.response.UseCaseResponse
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.usecase.FindJsonFeedByIdUseCase
import com.example.rss.domain.usecase.FindXmlFeedByIdUseCase
import com.example.rss.domain.usecase.jsonFeed.JsonFeedFavoriteUseCase
import com.example.rss.domain.usecase.jsonFeed.JsonFeedUnFavoriteUseCase
import com.example.rss.domain.usecase.xmlFeed.XmlFeedFavoriteUseCase
import com.example.rss.domain.usecase.xmlFeed.XmlFeedUnFavoriteUseCase
import javax.inject.Inject

class DetailFeedsViewModel @Inject constructor(
    private val findJsonFeedByIdUseCase: FindJsonFeedByIdUseCase,
    private val findXmlFeedByIdUseCase: FindXmlFeedByIdUseCase,
    private val jsonFeedFavoritesUseCase: JsonFeedFavoriteUseCase,
    private val jsonFeedUnFavoriteUseCase: JsonFeedUnFavoriteUseCase,
    private val xmlFeedFavoriteUseCase: XmlFeedFavoriteUseCase,
    private val xmlFeedUnFavoriteUseCase: XmlFeedUnFavoriteUseCase
) : BaseViewModel() {

    val feedsLiveData = MutableLiveData<FeedsModel>()

    private fun findJsonFeedById(id: String) {
        findJsonFeedByIdUseCase.setParameters(id).execute(
            this.compositeDisposable, this::onFindJsonFeedByIdUseCase
        )
    }

    private fun onFindJsonFeedByIdUseCase(response: UseCaseResponse<ArticleModel>) {
        when (response) {
            is SuccessResponse -> {
                feedsLiveData.value = response.value
            }
            is ErrorResponse -> {
            }
        }
    }

    private fun findXmlFeedById(id: String) {
        findXmlFeedByIdUseCase.setParameters(id)
            .execute(this.compositeDisposable, this::onFindXmlFeedById)
    }

    private fun onFindXmlFeedById(response: UseCaseResponse<DetailModel>) {
        when (response) {
            is SuccessResponse -> {
                feedsLiveData.value = response.value
            }
            is ErrorResponse -> {
                response.error

            }
        }
    }

    fun findFromDb(id: String,type: FeedsType) {
        when (type) {
            FeedsType.Json -> findJsonFeedById(id)
            FeedsType.Xml -> findXmlFeedById(id)
        }
    }

    private fun onFavoriteResponse(response: UseCaseResponse<Unit>) {
    }

    private fun favoriteXmlFeed(detailModel: DetailModel) {
        xmlFeedFavoriteUseCase.setParameters(detailModel).execute(
            this.compositeDisposable, this::onFavoriteResponse
        )
    }

    private fun unFavoriteXmlFeed(detailModel: DetailModel) {
        xmlFeedUnFavoriteUseCase.setParameters(detailModel).execute(
            this.compositeDisposable, this::onFavoriteResponse
        )
    }

    private fun favoriteJsonFeed(articleModel: ArticleModel) {
        jsonFeedFavoritesUseCase.setParameters(articleModel).execute(
            this.compositeDisposable, this::onFavoriteResponse
        )
    }

    private fun unFavoriteJsonFeed(articleModel: ArticleModel) {
        jsonFeedUnFavoriteUseCase.setParameters(articleModel).execute(
            this.compositeDisposable, this::onFavoriteResponse
        )
    }

    fun favoriteOrUnFavorite(type: FeedsType) {
        when (type) {
            FeedsType.Json -> {
                feedsLiveData.value.let {
                    if ((it as ArticleModel).isFavorite) unFavoriteJsonFeed(it)
                    else favoriteJsonFeed(it)
                }
            }
            FeedsType.Xml -> {
                feedsLiveData.value.let {
                    if ((it as DetailModel).isFavorite) unFavoriteXmlFeed(it)
                    else favoriteXmlFeed(it)
                }
            }
        }
    }
}