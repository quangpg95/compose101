package com.qq.compose101.feature.plants.data.repositoryimpl

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.core.functional.toLeft
import com.qq.compose101.core.functional.toRight
import com.qq.compose101.feature.plants.data.local.dao.GardenPlantingDao
import com.qq.compose101.feature.plants.data.local.table.GardenPlantingDB
import com.qq.compose101.feature.plants.data.local.table.convert
import com.qq.compose101.feature.plants.domain.entity.PlantAndGardenPlantings
import com.qq.compose101.feature.plants.domain.repository.GardenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GardenRepositoryImpl @Inject constructor(private val gardenPlantingDao: GardenPlantingDao) :
    GardenRepository {
    override suspend fun createPlanting(plantId: String) {
        gardenPlantingDao.insertGardenPlanting(GardenPlantingDB(plantId))
    }

    override fun isPlanted(plantId: String): Flow<Boolean> {
        return gardenPlantingDao.isPlanted(plantId)
    }

    override fun getPlantedGardens(): Either<Failure, Flow<List<PlantAndGardenPlantings>>> {
        return try {
            gardenPlantingDao.getPlantedGardens().map {
                it.map {
                    it.convert()
                }
            }.toRight()
        } catch (ex: Throwable) {
            Failure.DatabaseError.toLeft()
        }
    }
}