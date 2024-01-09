package com.qq.compose101.feature.plants.domain.usecase

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.entity.Plant
import com.qq.compose101.feature.plants.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlan @Inject constructor(private val plantRepository: PlantRepository) :
    UseCase<Flow<Plant>, String>() {
    override suspend fun run(params: String): Either<Failure, Flow<Plant>> {
        return plantRepository.getPlant(params)
    }
}