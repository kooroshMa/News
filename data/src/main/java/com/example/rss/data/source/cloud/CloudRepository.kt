package com.example.rss.data.source.cloud

import com.example.rss.data.di.JsonFeedQualifier
import com.example.rss.data.di.XmlFeedQualifier
import com.example.rss.data.restful.APIs
import com.example.rss.data.restful.JsonApis


class CloudRepository(
    private val xmlFeedApi: APIs,
    private val jsonFeedApi: JsonApis
) : BaseCloudRepository {

}