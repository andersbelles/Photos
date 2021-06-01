package com.example.data.source.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RemotePhoto(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)