package com.qq.compose101.feature.app.di

import android.content.Context
import com.qq.compose101.feature.plants.data.local.AppDatabase
import com.qq.compose101.feature.plants.data.local.dao.GardenPlantingDao
import com.qq.compose101.feature.plants.data.local.dao.PlantDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providerAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providerPlantDao(appDatabase: AppDatabase): PlantDao {
        return appDatabase.plantDao()
    }

    @Provides
    fun providerGardenPlatingDao(appDatabase: AppDatabase): GardenPlantingDao {
        return appDatabase.gardenPlantingDao()
    }
}