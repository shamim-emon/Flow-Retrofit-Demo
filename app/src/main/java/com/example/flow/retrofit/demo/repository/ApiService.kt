package com.example.flow.retrofit.demo.repository

import com.example.flow.retrofit.demo.model.ApiUser
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{page}")
    suspend fun getUsers(@Path("page") page: Int): List<ApiUser>

    @GET("error")
    suspend fun getUsersWithError(): List<ApiUser>

}
