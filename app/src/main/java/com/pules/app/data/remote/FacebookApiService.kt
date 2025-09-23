package com.pules.app.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface FacebookApiService {
    @GET("some_facebook_endpoint")
    suspend fun getFacebookData(@Query("access_token") accessToken: String): String
}


