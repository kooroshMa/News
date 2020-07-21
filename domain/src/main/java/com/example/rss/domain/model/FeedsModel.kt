package com.example.rss.domain.model

interface FeedsModel {
    val title:String?
    val isFavorite : Boolean?
}

enum class FeedsType {
    Json, Xml
}