package com.example.photos.di

import com.example.photos.ui.photodetails.PhotoDetailsViewModel
import com.example.photos.ui.photolist.PhotoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PhotoListViewModel(get()) }
    viewModel { PhotoDetailsViewModel(get()) }
}