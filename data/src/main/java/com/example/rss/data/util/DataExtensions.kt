package com.example.rss.data.util

import com.google.gson.Gson
import com.google.gson.JsonElement

inline fun <reified T> Gson.fromJson(jsonElement: JsonElement): T =
    this.fromJson(jsonElement, object : com.google.gson.reflect.TypeToken<T>() {}.type)

inline fun <reified T> Gson.fromJson(jsonStr: String): T =
    this.fromJson(jsonStr, object : com.google.gson.reflect.TypeToken<T>() {}.type)