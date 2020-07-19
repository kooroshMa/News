package com.example.rss.ui.home.xmlFeed

import androidx.annotation.VisibleForTesting
import com.example.rss.base.BaseViewModel
import com.example.rss.domain.model.response.ErrorResponse
import com.example.rss.domain.model.response.SuccessResponse
import com.example.rss.domain.model.response.UseCaseResponse
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.usecase.xmlFeed.XmlFeedUseCase
import javax.inject.Inject

class XmlFeedViewModel @Inject constructor(
    val navigator: XmlFeedNavigator,
    private val xmlFeedUseCase: XmlFeedUseCase
) : BaseViewModel() {

    private var xmlFeed: Unit? = null

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
                //showToastMessage(response.value[0].title)
            }
            is ErrorResponse -> {
                //showToastMessage("fail")
            }
        }
    }
}