package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.LoginRequest
import com.betrybe.trybnb.data.models.LoginToken
import com.betrybe.trybnb.data.models.bookingGetId
import com.betrybe.trybnb.data.models.bookingId
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("auth")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginToken>

    @GET("booking")
    suspend fun getbooking(): Response<List<bookingId>>

    @GET("booking/{id}")
    suspend fun getBookById(@Path("id") id: String, @Header("Accept") accept: String = "*/*"): Response<bookingGetId>
}
