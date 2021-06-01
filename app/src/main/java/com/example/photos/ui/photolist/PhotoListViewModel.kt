package com.example.photos.ui.photolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Result
import com.example.domain.model.Photo
import com.example.domain.repository.PhotosRepository
import com.example.photos.ui.UiState
import kotlinx.coroutines.launch

class PhotoListViewModel(private val photosRepository: PhotosRepository) : ViewModel() {

    private var _uiState = MutableLiveData<UiState<List<Photo>>>(UiState.Success(emptyList()))
    val uiState: LiveData<UiState<List<Photo>>> = _uiState

    fun fetchPhotos() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            when (val result = photosRepository.getPhotos()) {
                is Result.Success -> _uiState.value = UiState.Success(result.data)
                is Result.Failure -> _uiState.value = UiState.Failure(result.error)
            }
        }
    }

}