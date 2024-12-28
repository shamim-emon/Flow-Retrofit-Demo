package com.example.flow.retrofit.demo.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flow.retrofit.demo.model.ApiUser

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    users: List<ApiUser>,
    isLoading:Boolean,
    loadMoreItem: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        MyLazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            loadMoreItem = loadMoreItem,
            isLoading = isLoading,
            items = users
        ) {
            LazyColumnItem(user = it)
        }

    }
}