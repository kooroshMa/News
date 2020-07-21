package com.example.rss.data.mapper

import com.google.gson.Gson
import com.example.rss.data.util.HttpStatusCode
import com.example.rss.data.util.fromJson
import com.example.rss.domain.mapper.CloudErrorMapper
import com.example.rss.domain.model.response.DomainErrorException
import com.example.rss.domain.model.response.ErrorBody
import com.example.rss.domain.model.response.ErrorModel
import com.example.rss.domain.model.response.ErrorStatus
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class CloudErrorMapperImpl @Inject constructor(private val gson: Gson) : CloudErrorMapper {

    override fun mapToDomainErrorException(throwable: Throwable?): DomainErrorException {
        val errorModel: ErrorModel? = when (throwable) {

            is HttpException -> {
                if (throwable.code() == HttpStatusCode.UNAUTHORIZED.code) {
                    ErrorModel(
                        ErrorStatus.UNAUTHORIZED
                    )
                } else {
                    getHttpError(throwable.response()?.errorBody())
                }
            }

            is SocketTimeoutException -> {
                ErrorModel(
                    ErrorStatus.TIMEOUT
                )
            }

            is IOException -> {
                ErrorModel(
                    ErrorStatus.NO_CONNECTION
                )
            }
            else -> null
        }
        return DomainErrorException(errorModel ?: ErrorModel(ErrorStatus.UNKNOWN))
    }

    private fun getHttpError(body: ResponseBody?): ErrorModel {
        return try {
            val errorBody = gson.fromJson<ErrorBody>(body!!.string())
            val errorKeySet = errorBody.error.keySet()
            val errorList = if (errorKeySet.isNullOrEmpty()) {
                null
            } else {
                gson.fromJson<List<String>>(errorBody.error.get(errorKeySet.toList()[0]))
            }
            ErrorModel(
                errorBody.status,
                errorBody.message,
                errorList,
                ErrorStatus.BAD_RESPONSE
            )
        } catch (e: Throwable) {
            e.printStackTrace()
            ErrorModel(
                ErrorStatus.NOT_DEFINED
            )
        }
    }
}