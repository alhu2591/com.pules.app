package com.pules.app.data.repository.interfaces

import kotlinx.coroutines.flow.Flow

interface SocialMediaRepository {
    suspend fun getFacebookFeed(apiKey: String): Flow<List<String>>
    suspend fun getInstagramFeed(apiKey: String): Flow<List<String>>
    suspend fun getTikTokFeed(apiKey: String): Flow<List<String>>
}


