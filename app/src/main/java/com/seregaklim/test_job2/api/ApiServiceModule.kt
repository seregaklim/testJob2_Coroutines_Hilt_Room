package com.seregaklim.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiServiceModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return retrofit(okhttp())
            .create(ApiService::class.java)
    }

    private const val BASE_URL = "https://easypay.world/api-test/"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    fun okhttp(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    fun retrofit (client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

}

