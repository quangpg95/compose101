package com.qq.compose101.feature.plants.domain.entity

data class PlantAndGardenPlantings(
    val plant: Plant,
    val gardenPlantings: List<GardenPlanting>
)