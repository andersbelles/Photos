package com.example.data.source.remote.service

import com.example.data.BuildConfig
import com.example.data.source.remote.api.PhotosApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
    fun createPhotosApiService(): PhotosApi {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(OkHttpClient.Builder().build())
            .build().create(PhotosApi::class.java)
    }
}