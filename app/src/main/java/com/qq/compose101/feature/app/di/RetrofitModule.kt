package com.qq.compose101.feature.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {
    @Singleton
    @Provides
    fun providerInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    }

    @Singleton
    @Provides
    fun providerOkHttpClient(logger: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(logger).build()
    }

    @Singleton
    @Provides
    fun providerRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}