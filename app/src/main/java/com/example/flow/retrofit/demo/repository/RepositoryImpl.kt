package com.example.flow.retrofit.demo.repository

import com.example.flow.retrofit.demo.model.ApiUser
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val apiHelper: ApiHelper) : Repository {
    override  fun getUsers(): Flow<List<ApiUser>> {
        return apiHelper.getUsers()
    }

    override fun getUsersWithError(): Flow<List<ApiUser>> {
        return apiHelper.getUsersWithError()
    }
}