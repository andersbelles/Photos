package com.example.data.repository

import com.example.data.ext.safeApiCall
import com.example.data.source.remote.api.PhotosApi
import com.example.data.source.remote.mapper.toDomain
import com.example.domain.model.Photo
import com.example.domain.common.Result
import com.example.domain.repository.PhotosRepository

class PhotosRepositoryImpl(private val photosApi: PhotosApi) : PhotosRepository {
    override suspend fun getPhotos(): Result<List<Photo>> {
        return when (val result = safeApiCall { photosApi.getPhotos() }) {
            is Result.Success -> Result.Success(result.data.toDomain())
            is Result.Failure -> result
        }
    }

    override suspend fun getPhoto(id: Int): Result<Photo> {
        return when (val result = safeApiCall { photosApi.getPhoto(id) }) {
            is Result.Success -> Result.Success(result.data.toDomain())
            is Result.Failure -> result
        }
    }
}