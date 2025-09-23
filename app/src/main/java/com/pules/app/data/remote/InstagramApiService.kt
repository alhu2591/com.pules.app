package com.pules.app.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface InstagramApiService {
    @GET("some_instagram_endpoint")
    suspend fun getInstagramData(@Query("access_token") accessToken: String): String
}


