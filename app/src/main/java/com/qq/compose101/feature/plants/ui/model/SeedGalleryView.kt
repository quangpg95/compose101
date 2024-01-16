package com.qq.compose101.feature.plants.ui.model

import android.os.Parcelable
import com.qq.compose101.feature.plants.domain.entity.Gallery
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeedGalleryView(
    val results: List<SeedGalleryPhotoView>,
    val totalPages: Int
) : Parcelable {
    @Parcelize
    data class SeedGalleryPhotoView(
        val id: String,
        val seedGalleryPhotoUrls: SeedGalleryPhotoUrlsView,
        val seedGalleryUser: SeedGalleryUserView
    ) : Parcelable

    @Parcelize
    data class SeedGalleryPhotoUrlsView(val small: String) : Parcelable

    @Parcelize
    data class SeedGalleryUserView(
        val name: String,
        val userName: String,
        val attributionUrl: String
    ) : Parcelable
}

fun Gallery.GalleryUser.toDisplay() = SeedGalleryView.SeedGalleryUserView(
    name = this.name,
    userName = this.username,
    attributionUrl = this.attributionUrl
)

fun Gallery.GalleryPhotoUrls.toDisplay() = SeedGalleryView.SeedGalleryPhotoUrlsView(
    small = this.small
)

fun Gallery.GalleryPhoto.toDisplay() = SeedGalleryView.SeedGalleryPhotoView(
    id = this.id,
    seedGalleryPhotoUrls = this.urls.toDisplay(),
    seedGalleryUser = this.user.toDisplay()
)

fun Gallery.toDisplay() =
    SeedGalleryView(results = this.results.map { it.toDisplay() }, totalPages = this.totalPages)