package com.example.rss.domain.model

interface FeedsModel {
    val title:String?
    val isFavorite : Boolean?
    val link:String?
}

enum class FeedsType {
    Json, Xml
}