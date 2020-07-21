package com.example.rss.ui.home.xmlFeed

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.example.rss.base.BaseViewModel
import com.example.rss.domain.model.response.ErrorResponse
import com.example.rss.domain.model.response.SuccessResponse
import com.example.rss.domain.model.response.UseCaseResponse
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.usecase.xmlFeed.XmlFeedFavoriteUseCase
import com.example.rss.domain.usecase.xmlFeed.XmlFeedUnFavoriteUseCase
import com.example.rss.domain.usecase.xmlFeed.XmlFeedUseCase
import javax.inject.Inject

class XmlFeedViewModel @Inject constructor(
    val navigator: XmlFeedNavigator,
    private val xmlFeedUseCase: XmlFeedUseCase,
    private val xmlFeedFavoriteUseCase: XmlFeedFavoriteUseCase,
    private val xmlFeedUnFavoriteUseCase: XmlFeedUnFavoriteUseCase
) : BaseViewModel() {

    private var xmlFeed: Unit? = null

    val xmlFeedLiveData = MutableLiveData<List<DetailModel>>()


    override fun onResume() {
        super.onResume()

        if(xmlFeed==null){
            xmlFeed = getXmlFeed()
        }
    }

    private fun getXmlFeed() {
        xmlFeedUseCase.execute(this.compositeDisposable, this::onGetXmlFeedResponse)
    }

    @VisibleForTesting
    fun onGetXmlFeedResponse(response: UseCaseResponse<List<DetailModel>>){
        when (response) {
            is SuccessResponse -> {
                xmlFeedLiveData.value = response.value
            }
            is ErrorResponse -> {
            }
        }
    }

    fun favoriteXmlFeed(detailModel: DetailModel){
        xmlFeedFavoriteUseCase.setParameters(detailModel).execute(
            this.compositeDisposable, this::onFavoriteResponse)
    }

    private fun onFavoriteResponse(response: UseCaseResponse<Unit>) {
    }

    fun unFavoriteXmlFeed(detailModel: DetailModel){
        xmlFeedUnFavoriteUseCase.setParameters(detailModel).execute(
            this.compositeDisposable, this::onFavoriteResponse)
    }
}