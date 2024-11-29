package com.example.flow.retrofit.demo.repository

import kotlinx.coroutines.flow.flow

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override  fun getUsers() = flow {
        emit(apiService.getUsers())
    }

    override fun getUsersWithError() = flow {
        emit(apiService.getUsersWithError())
    }

}
