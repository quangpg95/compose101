package com.qq.compose101.feature.plants.data.di

import com.qq.compose101.feature.plants.data.remote.GalleryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PlantsApiModule {
    @Singleton
    @Provides
    fun provideGalleryApi(retrofit: Retrofit): GalleryApi {
        return retrofit.create(GalleryApi::class.java)
    }

}