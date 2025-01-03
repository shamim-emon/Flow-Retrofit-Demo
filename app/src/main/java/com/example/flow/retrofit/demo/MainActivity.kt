package com.example.flow.retrofit.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.flow.retrofit.demo.ui.theme.FlowRetrofitDemoTheme
import com.example.flow.retrofit.demo.ui.theme.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowRetrofitDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        loadMoreItem = viewModel::loadMore,
                        isLoading = viewModel.state.collectAsState().value.isLoading,
                        users = viewModel.state.collectAsState().value.users?: emptyList()
                    )
                }
            }
        }

        viewModel.getUsers(page = 1)
        lifecycleScope.launch {
            viewModel.state.collect { uiState ->
                when {
                    uiState.isLoading -> {
                        Timber.tag("EMON1234").d("Loading.......")
                    }
                    uiState.error != null -> {
                       // Timber.tag("EMON1234").d("Error:${uiState.error}")
                    }
                    else -> {
                        uiState.users?.forEach {
                           // Timber.tag("EMON1234").d("$it")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlowRetrofitDemoTheme {
        Greeting("Android")
    }
}