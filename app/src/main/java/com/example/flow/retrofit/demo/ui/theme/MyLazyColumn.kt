package com.example.flow.retrofit.demo.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.distinctUntilChanged
import timber.log.Timber

@Composable
fun <T> MyLazyColumn(
    modifier: Modifier = Modifier,
    items: List<T>,
    isLoading: Boolean,
    loadMoreItem: () -> Unit = {},
    content: @Composable (T) -> Unit
) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items.size) { index ->
            content(items[index])
        }
        if (isLoading &&items.isNotEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }


    }
    // Detect when the user scrolls to the end
    LaunchedEffect(lazyListState,items) {
        snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleItemIndex ->
                Timber.tag("EMON1234").d("lastVisibleItemIndex:$lastVisibleItemIndex | items.lastIndex:${items.lastIndex}")
                if (lastVisibleItemIndex == items.lastIndex && !isLoading) {
                    loadMoreItem.invoke()
                }
            }
    }

}

@Composable
fun <T> MyLazyRow(
    modifier: Modifier = Modifier,
    items: List<T>,
    isLoading: Boolean,
    loadMoreItem: () -> Unit = {},
    content: @Composable (T) -> Unit
) {
    val lazyListState = rememberLazyListState()

    LazyRow(
        modifier = modifier.fillMaxSize(),
        state = lazyListState,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items.size) { index ->
            content(items[index])
        }
        if (isLoading &&items.isNotEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }


    }
    // Detect when the user scrolls to the end
    LaunchedEffect(lazyListState,items) {
        snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleItemIndex ->
                Timber.tag("EMON1234").d("lastVisibleItemIndex:$lastVisibleItemIndex | items.lastIndex:${items.lastIndex}")
                if (lastVisibleItemIndex == items.lastIndex && !isLoading) {
                    loadMoreItem.invoke()
                }
            }
    }

}