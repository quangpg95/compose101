package com.qq.compose101.feature.plants.domain.repository

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings
import kotlinx.coroutines.flow.Flow

interface GardenRepository {
    suspend fun createPlanting(plantId: String): Either<Failure, Long>

    fun isPlanted(plantId: String): Either<Failure, Flow<Boolean>>

    fun getPlantedGardens(): Either<Failure, Flow<List<PlantAndGardenPlantings>>>


}