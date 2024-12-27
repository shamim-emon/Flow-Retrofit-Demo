package com.example.flow.retrofit.demo

import androidx.lifecycle.viewModelScope
import com.example.flow.retrofit.demo.model.ApiUser
import com.example.flow.retrofit.demo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    dispatcher: CoroutineDispatcher
) : BaseViewModel(dispatcher = dispatcher) {

    private val _state: MutableStateFlow<UserListState> = MutableStateFlow(UserListState())
    var state: StateFlow<UserListState> = _state

    fun getUsers(page: Int) {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch {
            handleFlow(
                dataFlow = repository.getUsers(page = page),
                onSuccess = { item: List<ApiUser> ->
                    _state.value = _state.value.copy(
                        users = item,
                        isLoading = false,
                        page = page,
                        error = null
                    )
                },
                onError = { message: String ->
                    _state.value = _state.value.copy(isLoading = false, error = message)
                }
            )
        }

    }
}

data class UserListState(
    val users: List<ApiUser>? = null,
    val page: Int = 1,
    override val isLoading: Boolean = false,
    override val error: String? = null
) : UIState(isLoading = isLoading, error = error)