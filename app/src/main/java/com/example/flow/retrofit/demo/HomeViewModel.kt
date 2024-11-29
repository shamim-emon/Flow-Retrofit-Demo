package com.example.flow.retrofit.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow.retrofit.demo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _users: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)
    var users: StateFlow<UIState> = _users

    fun getUsers() {
        viewModelScope.launch {
            repository.getUsers()
                .flowOn(dispatcher)
                .map {
                    UIState.Success(it) as UIState
                }
                .catch {
                    emit(UIState.Error(it.localizedMessage ?: "Something went wrong"))
                }
                .collect {
                    _users.value = it
                }
        }

    }


}