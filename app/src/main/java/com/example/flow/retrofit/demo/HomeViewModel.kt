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

    private val _users: MutableStateFlow<UserListState> = MutableStateFlow(UserListState())
    var users: StateFlow<UserListState> = _users

    fun getUsers() {
        _users.value = _users.value.copy(isLoading = true)
        viewModelScope.launch {
            handleFlow(
                dataFlow = repository.getUsersWithError(),
                onSuccess = { item: List<ApiUser> ->
                    _users.value = _users.value.copy(users = item, isLoading = false, error = null)
                },
                onError = { message: String ->
                    _users.value = _users.value.copy(isLoading = false, error = message)
                }
            )
        }

    }
}

data class UserListState(
    val users: List<ApiUser>? = null,
    override val isLoading: Boolean = false,
    override val error: String? = null
) : UIState(isLoading = isLoading, error = error)