package com.qq.compose101.feature.plants.ui.model

import android.os.Parcelable
import com.qq.compose101.feature.plants.domain.entity.Plant
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlantView(
    val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7,
    val imageUrl: String = ""
) : Parcelable


fun Plant.toDisplay(): PlantView {
    return PlantView(
        plantId = plantId,
        name = name,
        description = description,
        growZoneNumber = growZoneNumber,
        wateringInterval = wateringInterval,
        imageUrl = imageUrl
    )
}