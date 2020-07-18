package com.example.rss.domain.model.xmlFeed

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class XmlFeedModel(
    @Element(name = "channel")
    val channel: ChannelModel
)

@Root(name = "channel", strict = false)
data class ChannelModel(
    @ElementList(inline = true, name = "details")
    val details: List<Detail>? = null
)

@Root(name = "item", strict = false)
data class Detail(
    @Element(name = "title") val title: String,
    @Element(name = "link") val link: String,
    @Element(name = "description") val description: String,
    @Element(name = "enclosure") val enclosure: String,
    @Element(name = "category") val category: String,
    @Element(name = "pubDate") val pubDate: String,
    @Element(name = "guid") val guid: String

)
