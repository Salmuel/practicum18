package iu.c323.fall2024.practicum18.network

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "f331e7303585798455fd4b5af3cf0b7c"
interface Flicker {
    @GET("/")
    suspend fun fetchContents() : String

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): FlickerResponse
}