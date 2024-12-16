package com.example.flow.retrofit.demo

import com.example.flow.retrofit.demo.model.ApiUser

//sealed class UIState<T>{
//    data object Loading: UIState<Unit>()
//    data class Success<T>(val data: T) : UIState<T>()
//    data class Error(val message: String) : UIState<String>()
//}

//sealed class UIState<T>{
//    data object Loading: UIState<Unit>()
//    data class Success<T>(val data: T) : UIState<T>()
//    data class Error<String>(val message: String) : UIState<String>()
//}


open class UIState(open val isLoading :Boolean, open val error:String?)