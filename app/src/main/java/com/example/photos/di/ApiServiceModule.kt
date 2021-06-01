package com.example.photos.di

import com.example.data.source.remote.service.ApiService
import org.koin.dsl.module

val photosApiModule = module {
    single { ApiService.createPhotosApiService() }
}