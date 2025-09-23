package com.pules.app.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface TikTokApiService {
    @GET("some_tiktok_endpoint")
    suspend fun getTikTokData(@Query("access_token") accessToken: String): String
}


