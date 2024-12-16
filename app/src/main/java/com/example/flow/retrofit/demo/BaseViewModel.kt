package com.example.flow.retrofit.demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn


abstract class BaseViewModel(private val dispatcher: CoroutineDispatcher) : ViewModel() {


    protected suspend fun <T> handleFlow(
        dataFlow: Flow<T>,
        onSuccess: (item:T)->Unit,
        onError:(message:String)->Unit
    ) {
        dataFlow
            .flowOn(dispatcher)
            .catch {
                onError(it.localizedMessage ?: "Something Went Wrong")
            }
            .collect {
                onSuccess(it)
            }

    }
}