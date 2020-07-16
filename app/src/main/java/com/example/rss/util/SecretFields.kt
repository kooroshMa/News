package com.example.rss.util

import com.example.rss.BuildConfig

class SecretFields {

    private fun debugBaseURI(): String {
        return ""
    }

    private fun releaseBaseURI(): String {
        return ""
    }

    fun getBaseURI(): String {
        if (BuildConfig.BUILD_TYPE == "debug")
            return debugBaseURI()
        else if (BuildConfig.BUILD_TYPE == "release")
            return releaseBaseURI()
        else
            return ""
    }
}