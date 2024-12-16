package com.example.flow.retrofit.demo

import com.example.flow.retrofit.demo.model.ApiUser
import com.example.flow.retrofit.demo.repository.Repository
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()
    val dispatcher = testDispatcherRule.testDispatcher

    @Mock
    lateinit var repository: Repository
    lateinit var homeViewModel: HomeViewModel
    val users = listOf<ApiUser>(
        ApiUser(
            id = 0,
            name = "Akib",
            email = "akib24@gmail.com"
        ),
        ApiUser(
            id = 1,
            name = "Mamun",
            email = "mamun24@gmail.com"
        ),
        ApiUser(
            id = 3,
            name = "Rabbani",
            email = "rabbani24@gmail.com"
        )
    )

    @Before
    fun setUp() = runTest {
        `when`(repository.getUsers()).thenReturn(flowOf(users))
        homeViewModel = HomeViewModel(repository, dispatcher)
    }

    @Test
    fun `user successfully fetched`() = runTest(dispatcher) {
        homeViewModel.getUsers()
        testScheduler.advanceUntilIdle()
        assertThat(homeViewModel.users.value == UserListState(users)).isTrue()
    }
}