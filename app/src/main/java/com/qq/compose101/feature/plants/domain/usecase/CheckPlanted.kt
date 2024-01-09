package com.qq.compose101.feature.plants.domain.usecase

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.core.usecase.UseCase
import com.qq.compose101.feature.plants.domain.repository.GardenRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckPlanted @Inject constructor(private val gardenRepository: GardenRepository) :
    UseCase<Flow<Boolean>, String>() {
    override suspend fun run(params: String): Either<Failure, Flow<Boolean>> {
        return gardenRepository.isPlanted(params)
    }
}