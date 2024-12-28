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

    fun loadMore() {
        getUsers(page = _state.value.page + 1)
    }

    fun getUsers(page: Int) {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch {
            handleFlow(
                dataFlow = repository.getUsers(page = page),
                onSuccess = { item: List<ApiUser> ->
                    if (page == 1) {
                        _state.value = _state.value.copy(
                            users = item,
                            isLoading = false,
                            page = page,
                            error = null
                        )
                    } else {
                        if (item.isEmpty()) {
                            _state.value = _state.value.copy(
                                users = _state.value.users,
                                isLoading = false,
                                page = page,
                                error = null
                            )
                        } else {
                            _state.value = _state.value.copy(
                                users = _state.value.users?.plus(item),
                                isLoading = false,
                                page = page,
                                error = null
                            )
                        }
                    }
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