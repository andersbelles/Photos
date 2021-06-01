package com.example.data.source.remote.api

import com.example.data.source.remote.model.RemotePhoto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosApi {
    @GET("/photos")
    suspend fun getPhotos(): Response<List<RemotePhoto>>

    @GET("/photos/{id}")
    suspend fun getPhoto(@Path("id") id: Int): Response<RemotePhoto>

}