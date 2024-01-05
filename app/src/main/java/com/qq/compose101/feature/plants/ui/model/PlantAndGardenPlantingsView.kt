package com.qq.compose101.feature.plants.ui.model

import android.os.Parcelable
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlantAndGardenPlantingsView(
    val plantView: PlantView,
    val gardenPlantingViews: List<GardenPlantingView>
) : Parcelable

fun PlantAndGardenPlantings.toDisplay(): PlantAndGardenPlantingsView {
    return PlantAndGardenPlantingsView(
        plantView = plant.toDisplay(), gardenPlantingViews = gardenPlantings.map { it.toDisplay() }

    )
}