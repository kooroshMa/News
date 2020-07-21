package com.example.rss.ui.detail

import com.example.rss.base.BaseViewModel
import com.example.rss.domain.usecase.FindJsonFeedByIdUseCase
import com.example.rss.domain.usecase.FindXmlFeedByIdUseCase
import javax.inject.Inject

class DetailFeedsViewModel @Inject constructor(
    private val findJsonFeedByIdUseCase: FindJsonFeedByIdUseCase,
    private val findXmlFeedByIdUseCase: FindXmlFeedByIdUseCase
) : BaseViewModel() {


    fun onFavoriteClicked(){

    }
}