package com.mad.instagraph.remote.api

import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

sealed class NetworkResource<out T> {
    class Success<T>(val data: T?) : NetworkResource<T>()
    class Failure(val error: ApiException) : NetworkResource<Nothing>()
}


sealed class ApiException(val code: Int? = null, val body: ResponseBody? = null) : RuntimeException() {
    class HttpError(code: Int?, body: ResponseBody?) : ApiException(code, body)
    object TimeoutError : ApiException()
    object IOError : ApiException()
    object Unknown : ApiException()
}


inline fun <T> safeCall(block: () -> Response<T>): NetworkResource<T> {

    val result = runCatching { block() }

    return if (result.isSuccess) {
        val response = result.getOrNull()
        if (response != null) {
            if (response.isSuccessful) {
                NetworkResource.Success(response.body())
            } else {
                NetworkResource.Failure(
                    ApiException.HttpError(response.code(), response.errorBody())
                )
            }
        } else {
            NetworkResource.Failure(ApiException.Unknown)
        }
    } else {
        val exception = result.exceptionOrNull()
        exception?.printStackTrace()
        return when (exception) {
            is TimeoutException, is SocketTimeoutException -> NetworkResource.Failure(ApiException.TimeoutError)
            is IOException -> NetworkResource.Failure(ApiException.IOError)
            else -> NetworkResource.Failure(ApiException.Unknown)
        }
    }

}