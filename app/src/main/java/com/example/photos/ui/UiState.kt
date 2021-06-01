package com.example.photos.ui

import com.example.domain.common.Error

sealed class UiState<out T> {

    object Loading : UiState<Nothing>()

    data class Success<T>(val data: T) : UiState<T>()

    data class Failure(val error: Error) : UiState<Nothing>()
}