package com.example.data.source.remote.mapper

import com.example.data.source.remote.model.RemotePhoto
import com.example.domain.model.Photo

fun RemotePhoto.toDomain(): Photo = Photo(id, albumId, title, url, thumbnailUrl)

fun List<RemotePhoto>.toDomain(): List<Photo> = map { it.toDomain() }