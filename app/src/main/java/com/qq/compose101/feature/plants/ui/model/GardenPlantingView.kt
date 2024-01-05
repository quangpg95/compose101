package com.qq.compose101.feature.plants.ui.model

import android.os.Parcelable
import com.qq.compose101.core.utils.toDisplay
import com.qq.compose101.feature.plants.domain.entity.GardenPlanting
import kotlinx.parcelize.Parcelize

@Parcelize
data class GardenPlantingView(
    val plantId: String,
    val plantDate: String,
    val lastWateringDate: String,
    val gardenPlantingId: Long
) : Parcelable

fun GardenPlanting.toDisplay(): GardenPlantingView {
    return GardenPlantingView(
        plantId = plantId,
        plantDate = plantDate.toDisplay(),
        lastWateringDate = lastWateringDate.toDisplay(),
        gardenPlantingId = gardenPlantingId
    )
}