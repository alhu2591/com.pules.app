package com.pules.app.di

import com.pules.app.data.remote.FacebookApiService
import com.pules.app.data.remote.InstagramApiService
import com.pules.app.data.remote.TikTokApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with actual base URL
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFacebookApiService(retrofit: Retrofit): FacebookApiService {
        return retrofit.create(FacebookApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideInstagramApiService(retrofit: Retrofit): InstagramApiService {
        return retrofit.create(InstagramApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTikTokApiService(retrofit: Retrofit): TikTokApiService {
        return retrofit.create(TikTokApiService::class.java)
    }
}


