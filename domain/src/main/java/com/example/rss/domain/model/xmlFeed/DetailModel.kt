package com.example.rss.domain.model.xmlFeed

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.*


private const val TABLE_NAME = "xmlFeed"

@Entity(tableName = TABLE_NAME)
@Root(name = "item", strict = false)
@Parcelize
data class DetailModel @JvmOverloads constructor(
    @ColumnInfo(name = "title")
    @field:Path("title")
    @field:Text(required = false)
    @param:Path("title")
    @param:Text(required = false)
    val title: String? = null,

    @ColumnInfo(name = "link")
    @field:Path("link")
    @field:Text(required = false)
    @param:Path("link")
    @param:Text(required = false)
    val link: String? = null,

    @ColumnInfo(name = "description")
    @field:Path("description")
    @field:Text(required = false)
    @param:Path("description")
    @param:Text(required = false)
     val description: String? = null,

    @ColumnInfo(name = "enclosure")
    @field:Path("enclosure")
    @param:Path("enclosure")
    @field:Attribute(name = "url", required = false)
    @param:Attribute(name = "url", required = false)
    val imageUrl: String? = null,

    @ColumnInfo(name = "category")
    @field:Path("category")
    @field:Text(required = false)
    @param:Path("category")
    @param:Text(required = false)
    val category: String? = null,

    @ColumnInfo(name = "pubDate")
    @field:Path("pubDate")
    @field:Text(required = false)
    @param:Path("pubDate")
    @param:Text(required = false)
    val date: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "guid")
    @field:Element(name = "guid")
    @param:Element(name = "guid")
    val guid: String = "",

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean = false
): Parcelable