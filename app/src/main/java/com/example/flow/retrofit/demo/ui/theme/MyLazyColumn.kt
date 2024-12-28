package com.example.flow.retrofit.demo.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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

enum class LayoutType {
    LazyColumn,
    LazyRow,
    LazyVerticalGrid,
    LazyHorizontalGrid
}

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
        if (isLoading && items.isNotEmpty()) {
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
    LaunchedEffect(lazyListState, items) {
        snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleItemIndex ->
                Timber.tag("EMON1234")
                    .d("lastVisibleItemIndex:$lastVisibleItemIndex | items.lastIndex:${items.lastIndex}")
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
        if (isLoading && items.isNotEmpty()) {
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
    LaunchedEffect(lazyListState, items) {
        snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleItemIndex ->
                Timber.tag("EMON1234")
                    .d("lastVisibleItemIndex:$lastVisibleItemIndex | items.lastIndex:${items.lastIndex}")
                if (lastVisibleItemIndex == items.lastIndex && !isLoading) {
                    loadMoreItem.invoke()
                }
            }
    }

}

@Composable
fun <T> MyLazyVerticalGrid(
    modifier: Modifier = Modifier,
    items: List<T>,
    noOfColumn: Int,
    isLoading: Boolean,
    loadMoreItem: () -> Unit = {},
    content: @Composable (T) -> Unit
) {
    val lazyGridState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(noOfColumn),
        state = lazyGridState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Add padding around the grid
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between columns
        verticalArrangement = Arrangement.spacedBy(16.dp) // Spacing between rows
    ) {
        items(items.size) { index ->
            content(items[index])
        }
        if (isLoading && items.isNotEmpty()) {
            item(span = { GridItemSpan(noOfColumn) }) {
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
    LaunchedEffect(lazyGridState, items) {
        snapshotFlow { lazyGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleItemIndex ->
                Timber.tag("EMON1234")
                    .d("lastVisibleItemIndex:$lastVisibleItemIndex | items.lastIndex:${items.lastIndex}")
                if (lastVisibleItemIndex == items.lastIndex && !isLoading) {
                    loadMoreItem.invoke()
                }
            }
    }

}

@Composable
fun <T> MyLazyHorizontalGrid(
    modifier: Modifier = Modifier,
    items: List<T>,
    noOfRows: Int,
    isLoading: Boolean,
    loadMoreItem: () -> Unit = {},
    content: @Composable (T) -> Unit
) {
    val lazyGridState = rememberLazyGridState()

    LazyHorizontalGrid(
        rows = GridCells.Fixed(noOfRows),
        state = lazyGridState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Add padding around the grid
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between columns
        verticalArrangement = Arrangement.spacedBy(16.dp) // Spacing between rows
    ) {
        items(items.size) { index ->
            content(items[index])
        }
        if (isLoading && items.isNotEmpty()) {
            item(span = { GridItemSpan(noOfRows) }) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentHeight(Alignment.CenterVertically)
                )
            }
        }
    }

    // Detect when the user scrolls to the end
    LaunchedEffect(lazyGridState, items) {
        snapshotFlow { lazyGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleItemIndex ->
                Timber.tag("EMON1234")
                    .d("lastVisibleItemIndex:$lastVisibleItemIndex | items.lastIndex:${items.lastIndex}")
                if (lastVisibleItemIndex == items.lastIndex && !isLoading) {
                    loadMoreItem.invoke()
                }
            }
    }

}

