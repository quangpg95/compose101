package com.qq.compose101.feature.plants.domain.usecase

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings
import com.qq.compose101.feature.plants.domain.repository.GardenRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGardens @Inject constructor(private val gardenRepository: GardenRepository) :
    UseCase<Flow<List<PlantAndGardenPlantings>>, UseCase.None>() {
    override suspend fun run(params: None): Either<Failure, Flow<List<PlantAndGardenPlantings>>> {
        return gardenRepository.getPlantedGardens()
    }
}