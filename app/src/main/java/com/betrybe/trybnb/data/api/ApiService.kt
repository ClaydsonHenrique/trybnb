package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.LoginRequest
import com.betrybe.trybnb.data.models.LoginToken
import retrofit2.Response
import retrofit2.http.*
interface ApiService {
    @POST("auth")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginToken>
}
