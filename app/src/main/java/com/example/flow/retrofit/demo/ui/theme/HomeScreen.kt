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
    isLoading: Boolean,
    loadMoreItem: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

//        MyScrollable(
//            modifier = Modifier.fillMaxSize(),
//            items = users,
//            isLoading = isLoading,
//            layoutType = LayoutType.LazyRow,
//            loadMoreItem = loadMoreItem
//        ) {
//            LazyColumnItem(it)
//        }

//        MyScrollable(
//            modifier = Modifier.fillMaxSize(),
//            items = users,
//            isLoading = isLoading,
//            layoutType = LayoutType.LazyColumn,
//            loadMoreItem = loadMoreItem
//        ) {
//            LazyColumnItem(it)
//        }

//        MyScrollable(
//            modifier = Modifier.fillMaxSize(),
//            items = users.map { it.id },
//            isLoading = isLoading,
//            layoutType = LayoutType.LazyVerticalGrid(2),
//            loadMoreItem = loadMoreItem
//        ) {
//            GridItem(it)
//        }

        MyScrollable(
            modifier = Modifier.fillMaxSize(),
            items = users.map { it.id },
            isLoading = isLoading,
            layoutType = LayoutType.LazyHorizontalGrid(2),
            loadMoreItem = loadMoreItem
        ) {
            GridItem(it)
        }

    }
}