package com.example.photos.ui.photodetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Result
import com.example.domain.model.Photo
import com.example.domain.repository.PhotosRepository
import com.example.photos.ui.UiState
import kotlinx.coroutines.launch

class PhotoDetailsViewModel(private val photosRepository: PhotosRepository) : ViewModel() {

    private var _uiState = MutableLiveData<UiState<Photo>>(UiState.Loading)
    val uiState: LiveData<UiState<Photo>> = _uiState

    fun fetchPhoto(id: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            when (val result = photosRepository.getPhoto(id)) {
                is Result.Success -> _uiState.value = UiState.Success(result.data)
                is Result.Failure -> _uiState.value = UiState.Failure(result.error)
            }
        }
    }
}