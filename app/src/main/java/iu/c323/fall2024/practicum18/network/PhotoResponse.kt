package iu.c323.fall2024.practicum18.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponse(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: String,
    @Json(name = "photo") val photos: List<GalleryItem>
)

