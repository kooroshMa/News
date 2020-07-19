package com.example.rss.domain.model.jsonFeed

import com.google.gson.annotations.SerializedName

data class JsonFeedModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResult: Int,
    @SerializedName("articles")
    val articles: List<ArticleModel>
)