package com.qq.compose101.feature.plants.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.qq.compose101.feature.plants.data.local.table.PlantDB
import kotlinx.coroutines.flow.Flow

/**
 * The Data Access Object for the Plant class.
 */
@Dao
interface PlantDao {
    @Query("SELECT * FROM plants ORDER BY name")
    fun getPlants(): Flow<List<PlantDB>>

    @Query("SELECT * FROM plants WHERE growZoneNumber = :growZoneNumber ORDER BY name")
    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<PlantDB>>

    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlant(plantId: String): Flow<PlantDB>

    @Upsert
    suspend fun upsertAll(plants: List<PlantDB>)
}
