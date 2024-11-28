package com.example.flow.retrofit.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow.retrofit.demo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import timber.log.Timber
import javax.inject.Inject
import kotlin.jvm.Throws

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    val users : StateFlow<UIState> = repository.getUsers() // repository.getUsersWithError()
        .flowOn(dispatcher)
        .map {
            UIState.Success(it) as UIState
        }
        .catch {
            emit(UIState.Error(it.localizedMessage?:"Something went wrong"))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = UIState.Loading
        )

}