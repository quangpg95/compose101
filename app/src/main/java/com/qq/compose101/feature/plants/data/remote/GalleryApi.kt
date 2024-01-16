package com.qq.compose101.feature.plants.data.remote

import com.qq.compose101.BuildConfig
import com.qq.compose101.feature.plants.data.remote.response.GalleryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GalleryApi {
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("client_id") clientId: String = BuildConfig.UNSPLASH_ACCESS_KEY
    ): GalleryResponse
}