package com.example.rss.domain.model.xmlFeed

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.*

@Root(name = "item", strict = false)
@Parcelize
data class DetailModel @JvmOverloads constructor(
    @field:Path("title")
    @field:Text(required = false)
    @param:Path("title")
    @param:Text(required = false)
    val title: String? = null,

    @field:Path("link")
    @field:Text(required = false)
    @param:Path("link")
    @param:Text(required = false)
    val link: String? = null,

    @field:Path("description")
    @field:Text(required = false)
    @param:Path("description")
    @param:Text(required = false)
     val description: String? = null,

    @field:Path("enclosure")
    @param:Path("enclosure")
    @field:Attribute(name = "url", required = false)
    @param:Attribute(name = "url", required = false)
    val imageUrl: String? = null,

    @field:Path("category")
    @field:Text(required = false)
    @param:Path("category")
    @param:Text(required = false)
    val category: String? = null,

    @field:Path("pubDate")
    @field:Text(required = false)
    @param:Path("pubDate")
    @param:Text(required = false)
    val date: String? = null,

    @field:Path("isFavorite")
    @field:Text(required = false)
    @param:Path("isFavorite")
    @param:Text(required = false)
    val isFavorite: Boolean? = false,

    @field:Element(name = "guid")
    @param:Element(name = "guid")
    val guid: String = ""
): Parcelable