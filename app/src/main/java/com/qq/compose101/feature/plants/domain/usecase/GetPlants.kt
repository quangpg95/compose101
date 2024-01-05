package com.qq.compose101.feature.plants.domain.usecase

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.entity.Plant
import com.qq.compose101.feature.plants.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlants @Inject constructor(
    private val plantRepository: PlantRepository
) : UseCase<Flow<List<Plant>>, Int>() {
    override suspend fun run(growZoneNumber: Int): Either<Failure, Flow<List<Plant>>> {
        return if (growZoneNumber == -1) {
            plantRepository.getPlants()
        } else {
            plantRepository.getPlantsWithGrowZoneNumber(growZoneNumber)
        }
    }
}