package com.qq.compose101.feature.plants.domain.entity

import java.util.Calendar

data class GardenPlanting(
    val plantId: String,
    val plantDate: Calendar = Calendar.getInstance(),
    val lastWateringDate: Calendar = Calendar.getInstance(),
    val gardenPlantingId: Long
)