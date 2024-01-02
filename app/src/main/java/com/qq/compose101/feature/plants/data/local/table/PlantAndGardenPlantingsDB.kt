package com.qq.compose101.feature.plants.data.local.table

import androidx.room.Embedded
import androidx.room.Relation
import com.qq.compose101.feature.plants.domain.entity.Plant
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings

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

fun PlantAndGardenPlantingsDB.convert() = PlantAndGardenPlantings(
    plant = plant.convert(), gardenPlantings = gardenPlantings.map { it.convert() }
)
