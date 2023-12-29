package com.qq.compose101.feature.plants.data.local.table

import androidx.room.Embedded
import androidx.room.Relation

/**
 * This class captures the relationship between a [PlantDB] and a user's [GardenPlantingDB], which is
 * used by Room to fetch the related entities.
 */
data class PlantAndGardenPlantingsDB(
    @Embedded
    val plant: PlantDB,

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    val gardenPlantings: List<GardenPlantingDB> = emptyList()
)
