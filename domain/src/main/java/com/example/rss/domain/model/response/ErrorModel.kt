package com.example.rss.domain.model.response

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ErrorModel(
    val code: Int?,
    val message: String?,
    val errorCauseList: List<String>?,
    @Transient var errorStatus: ErrorStatus
) {
    constructor(errorStatus: ErrorStatus) : this(null, null, null, errorStatus)
}

data class ErrorBody(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String?,
    @SerializedName("error") val error: JsonObject
)