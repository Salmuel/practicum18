package iu.c323.fall2024.practicum18.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickerResponse(
    val photos: PhotoResponse
)
