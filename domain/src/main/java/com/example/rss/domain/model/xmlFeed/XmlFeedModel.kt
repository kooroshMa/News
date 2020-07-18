package com.example.rss.domain.model.xmlFeed

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)
data class XmlFeedModel(
    @field:Element(name = "channel")
    @param:Element(name = "channel")
    val channel: ChannelModel? = null
)




