package com.pules.app.data.repository

import com.pules.app.data.remote.FacebookApiService
import com.pules.app.data.remote.InstagramApiService
import com.pules.app.data.remote.TikTokApiService
import com.pules.app.data.repository.interfaces.SocialMediaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SocialMediaRepositoryImpl @Inject constructor(
    private val facebookApiService: FacebookApiService,
    private val instagramApiService: InstagramApiService,
    private val tikTokApiService: TikTokApiService
) : SocialMediaRepository {

    override suspend fun getFacebookFeed(apiKey: String): Flow<List<String>> = flow {
        try {
            val data = facebookApiService.getFacebookData(apiKey)
            emit(listOf("Facebook data: $data"))
        } catch (e: HttpException) {
            // Handle HTTP errors
            emit(listOf("Error fetching Facebook data: ${e.message()}"))
        } catch (e: IOException) {
            // Handle network errors
            emit(listOf("Network error fetching Facebook data: ${e.message}"))
        } catch (e: Exception) {
            // Handle other unexpected errors
            emit(listOf("Unknown error fetching Facebook data: ${e.message}"))
        }
    }

    override suspend fun getInstagramFeed(apiKey: String): Flow<List<String>> = flow {
        try {
            val data = instagramApiService.getInstagramData(apiKey)
            emit(listOf("Instagram data: $data"))
        } catch (e: HttpException) {
            emit(listOf("Error fetching Instagram data: ${e.message()}"))
        } catch (e: IOException) {
            emit(listOf("Network error fetching Instagram data: ${e.message}"))
        } catch (e: Exception) {
            emit(listOf("Unknown error fetching Instagram data: ${e.message}"))
        }
    }

    override suspend fun getTikTokFeed(apiKey: String): Flow<List<String>> = flow {
        try {
            val data = tikTokApiService.getTikTokData(apiKey)
            emit(listOf("TikTok data: $data"))
        } catch (e: HttpException) {
            emit(listOf("Error fetching TikTok data: ${e.message()}"))
        } catch (e: IOException) {
            emit(listOf("Network error fetching TikTok data: ${e.message}"))
        } catch (e: Exception) {
            emit(listOf("Unknown error fetching TikTok data: ${e.message}"))
        }
    }
}


