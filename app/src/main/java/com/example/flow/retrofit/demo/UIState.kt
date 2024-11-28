package com.example.flow.retrofit.demo

import com.example.flow.retrofit.demo.model.ApiUser

sealed class UIState {
    data object Loading : UIState()
    data class Success(val users: List<ApiUser>) : UIState()
    data class Error(val message: String) : UIState()
}