package com.example.flow.retrofit.demo.repository

import com.example.flow.retrofit.demo.model.ApiUser
import kotlinx.coroutines.flow.Flow

interface Repository {
     fun getUsers(page:Int): Flow<List<ApiUser>>

    fun getUsersWithError(): Flow<List<ApiUser>>
}