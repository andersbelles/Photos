package com.example.photos

import android.app.Application
import com.example.photos.di.photosApiModule
import com.example.photos.di.photosRepositoryModule
import com.example.photos.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                photosApiModule,
                photosRepositoryModule,
                viewModelModule
            )
        }
    }
}