package com.example.rss.util

import com.example.rss.BuildConfig

class SecretFields {

    private fun debugBaseURI(): String {
        return "https://www.khabaronline.ir/"
    }
    private fun releaseBaseURI(): String {
        return "https://www.khabaronline.ir/"
    }

    private fun debugJsonBaseURI(): String {
        return "http://newsapi.org/v2/"
    }
    private fun releaseJsonBaseURI(): String {
        return "http://newsapi.org/v2/"
    }

    fun getBaseURI(): String {
        if (BuildConfig.BUILD_TYPE == "debug")
            return debugBaseURI()
        else if (BuildConfig.BUILD_TYPE == "release")
            return releaseBaseURI()
        else
            return ""
    }

    fun getJsonBaseURI(): String {
        if (BuildConfig.BUILD_TYPE == "debug")
            return debugJsonBaseURI()
        else if (BuildConfig.BUILD_TYPE == "release")
            return releaseJsonBaseURI()
        else
            return ""
    }
}