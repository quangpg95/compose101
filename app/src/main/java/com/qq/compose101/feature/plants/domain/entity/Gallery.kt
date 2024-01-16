package com.qq.compose101.feature.plants.domain.entity

data class Gallery(
    val results: List<GalleryPhoto>,
    val totalPages: Int
) {
    data class GalleryPhoto(
        val id: String,
        val urls: GalleryPhotoUrls,
        val user: GalleryUser
    )

    data class GalleryPhotoUrls(
        val small: String
    )

    data class GalleryUser(
        val name: String,
        val username: String
    ) {
        val attributionUrl: String
            get() {
                return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
            }
    }
}
