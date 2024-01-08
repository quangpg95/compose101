package com.qq.compose101.feature.plants.domain.usecase

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.repository.GardenRepository
import javax.inject.Inject

class CreateGarden @Inject constructor(private val gardenRepository: GardenRepository) :
    UseCase<Long, String>() {
    override suspend fun run(params: String): Either<Failure, Long> {
        return gardenRepository.createPlanting(params)
    }
}