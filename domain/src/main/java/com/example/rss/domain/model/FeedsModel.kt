package com.example.rss.domain.model

interface FeedsModel {
    val title:String?
}

enum class FeedsType {
    Json, Xml
}