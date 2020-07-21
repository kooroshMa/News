package com.example.rss.domain.model.jsonFeed

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rss.domain.model.FeedsModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

private const val TABLE_NAME = "jsonFeed"

@Entity(tableName = TABLE_NAME)
@Parcelize
data class ArticleModel(
    @ColumnInfo(name = "author")
    @SerializedName("author")
    val author: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    override val title: String,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,
    @PrimaryKey
    @ColumnInfo(name = "url")
    @SerializedName("url")
    val link: String,
    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage")
    val image: String,
    @ColumnInfo(name = "publishedAt")
    @SerializedName("publishedAt")
    val date: String,
    @ColumnInfo(name = "content")
    @SerializedName("content")
    val content: String,
    @ColumnInfo(name = "isFavorite")
    override val isFavorite: Boolean = false

):Parcelable, FeedsModel