package com.example.domain.common

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val error: Error) : Result<Nothing>()
}

sealed class Error {
    abstract val message: String

    sealed class Network : Error() {
        data class NotConnected(override val message: String = "No internet connection") : Network()
        data class Unknown(override val message: String) : Network()
    }

    data class Unknown(override val message: String) : Error()
}