package com.example.domain.repository

import com.example.domain.model.Photo
import com.example.domain.common.Result

interface PhotosRepository {

    suspend fun getPhotos(): Result<List<Photo>>

    suspend fun getPhoto(id: Int): Result<Photo>

}