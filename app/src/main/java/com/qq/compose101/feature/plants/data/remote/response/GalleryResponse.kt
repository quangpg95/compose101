package com.qq.compose101.feature.plants.data.remote.response

import com.google.gson.annotations.SerializedName
import com.qq.compose101.feature.plants.domain.entity.SeedGallery

data class GalleryResponse(
    @field:SerializedName("results") val results: List<GalleryPhotoResponse>,
    @field:SerializedName("total_pages") val totalPages: Int
) {
    data class GalleryPhotoResponse(
        @field:SerializedName("id") val id: String,
        @field:SerializedName("urls") val urls: GalleryPhotoUrlsResponse,
        @field:SerializedName("user") val user: GalleryUserResponse
    )

    data class GalleryPhotoUrlsResponse(
        @field:SerializedName("small") val small: String
    )

    data class GalleryUserResponse(
        @field:SerializedName("name") val name: String,
        @field:SerializedName("username") val username: String
    ) {
        val attributionUrl: String
            get() {
                return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
            }
    }
}

fun GalleryResponse.convert() = SeedGallery(
    results = this.results.map {
        SeedGallery.SeedGalleryPhoto(
            id = it.id, seedGalleryPhotoUrls = SeedGallery.SeedGalleryPhotoUrls(
                small = it.urls.small
            ), seedGalleryUser = SeedGallery.SeedGalleryUser(
                name = it.user.name,
                userName = it.user.username,
                attributionUrl = it.user.attributionUrl
            )
        )
    },
    totalPages = this.totalPages
)