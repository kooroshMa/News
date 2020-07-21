package com.example.rss.util.connectivity

interface BaseConnectionManager {

    fun isNetworkConnected(): Boolean?

    fun isVPNConnected(): Boolean?

    fun getIPV4(): String?

    fun isWifi(): Boolean?

    fun isMobileData(): Boolean?
}