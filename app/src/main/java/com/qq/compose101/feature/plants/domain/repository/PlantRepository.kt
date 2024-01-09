package com.qq.compose101.feature.plants.domain.repository

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.feature.plants.domain.entity.Plant
import kotlinx.coroutines.flow.Flow

interface PlantRepository {
    fun getPlants(): Either<Failure, Flow<List<Plant>>>

    fun getPlant(plantId: String): Either<Failure, Flow<Plant>>

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Either<Failure, Flow<List<Plant>>>
}