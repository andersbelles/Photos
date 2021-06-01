package com.example.data.ext

import android.util.Log
import retrofit2.Response
import java.net.UnknownHostException
import com.example.domain.common.Result
import com.example.domain.common.Error


suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> =
    try {
        val response = call.invoke()

        when {
            response.isSuccessful -> Result.Success(response.body() as T)
            else -> Result.Failure(Error.Unknown(response.message()))
        }

    } catch (e: UnknownHostException) {
        Result.Failure(Error.Network.NotConnected())
    } catch (e: Exception) {
        Log.d("Unknown request error", "${e.javaClass.simpleName} ${e.message}")
        Result.Failure(Error.Unknown("Unknown error"))
    }