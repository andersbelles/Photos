package com.example.photos.di

import com.example.data.repository.PhotosRepositoryImpl
import com.example.domain.repository.PhotosRepository
import org.koin.dsl.module


val photosRepositoryModule = module {
    single<PhotosRepository> { PhotosRepositoryImpl(get()) }
}
