package com.qq.compose101.feature.plants.data.repositoryimpl

import com.qq.compose101.core.failure.Failure
import com.qq.compose101.core.functional.Either
import com.qq.compose101.core.functional.toLeft
import com.qq.compose101.core.functional.toRight
import com.qq.compose101.feature.plants.data.local.dao.PlantDao
import com.qq.compose101.feature.plants.data.local.table.convert
import com.qq.compose101.feature.plants.domain.entity.Plant
import com.qq.compose101.feature.plants.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlantRepositoryImpl @Inject constructor(private val plantDao: PlantDao) : PlantRepository {
    override fun getPlants(): Either<Failure, Flow<List<Plant>>> {
        return try {
            plantDao.getPlants().map {
                it.map {
                    it.convert()
                }
            }.toRight()
        } catch (exception: Throwable) {
            Failure.DatabaseError.toLeft()
        }
    }

    override fun getPlant(plantId: String): Either<Failure, Flow<Plant>> {
        return plantDao.getPlant(plantId).map {
            it.convert()
        }.toRight()
    }

    override fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Either<Failure, Flow<List<Plant>>> {
        return try {
            plantDao.getPlantsWithGrowZoneNumber(growZoneNumber).map {
                it.map {
                    it.convert()
                }
            }.toRight()
        }catch (exception: Throwable) {
            Failure.DatabaseError.toLeft()
        }
    }

//    private fun <T, R> request(
//        call: Call<T>,
//        transform: (T) -> R,
//        default: T
//    ): Either<Failure, R> {
//        return try {
//            val response = call.execute()
//            when (response.isSuccessful) {
//                true -> Either.Right(transform((response.body() ?: default)))
//                false -> Either.Left(Failure.ServerError)
//            }
//        } catch (exception: Throwable) {
//            Either.Left(Failure.ServerError)
//        }
//    }
}