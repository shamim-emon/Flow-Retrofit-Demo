package com.example.flow.retrofit.demo.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

class RetrofitBuilder (private val converterFactory: GsonConverterFactory){

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()
    }
}