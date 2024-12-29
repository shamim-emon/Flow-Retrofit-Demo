package com.example.flow.retrofit.demo.ui.theme

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
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

sealed class LayoutType {
    data object LazyColumn : LayoutType()
    data object LazyRow : LayoutType()
    data class LazyVerticalGrid(val columns: Int) : LayoutType()
    data class LazyHorizontalGrid(val rows: Int) : LayoutType()
}

@Composable
fun <T> MyScrollable(
    modifier: Modifier = Modifier,
    items: List<T>,
    isLoading: Boolean,
    layoutType: LayoutType,
    loadMoreItem: () -> Unit = {},
    content: @Composable (T) -> Unit
) {
    when (layoutType) {
        is LayoutType.LazyColumn -> {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                items = items,
                isLoading = isLoading,
                loadMoreItem = loadMoreItem,
                content = content
            )
        }

        is LayoutType.LazyRow -> {
            LazyRow(
                modifier = modifier.fillMaxSize(),
                items = items,
                isLoading = isLoading,
                loadMoreItem = loadMoreItem,
                content = content
            )
        }

        is LayoutType.LazyVerticalGrid -> {
             LazyVerticalGrid(
                 modifier = modifier.fillMaxSize(),
                 columns = layoutType.columns,
                 items = items,
                 isLoading = isLoading,
                 loadMoreItem = loadMoreItem,
                 content = content
             )
        }

        is LayoutType.LazyHorizontalGrid -> {
            LazyHorizontalGrid(
                modifier = modifier.fillMaxSize(),
                rows = layoutType.rows,
                items = items,
                isLoading = isLoading,
                loadMoreItem = loadMoreItem,
                content = content
            )
        }
    }
}


@Composable
fun <T> LazyColumn(
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
        observeLastVisibleItemAndLoadMoreCollect(
            state = lazyListState,
            items = items,
            isLoading = isLoading,
            loadMoreItem = loadMoreItem
        )
    }

}

@Composable
fun <T> LazyRow(
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
        observeLastVisibleItemAndLoadMoreCollect(
            state = lazyListState,
            items = items,
            isLoading = isLoading,
            loadMoreItem = loadMoreItem
        )
    }

}

@Composable
fun <T> LazyVerticalGrid(
    modifier: Modifier = Modifier,
    items: List<T>,
    columns: Int,
    isLoading: Boolean,
    loadMoreItem: () -> Unit = {},
    content: @Composable (T) -> Unit
) {
    val lazyGridState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        state = lazyGridState,
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Add padding around the grid
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between columns
        verticalArrangement = Arrangement.spacedBy(16.dp) // Spacing between rows
    ) {
        items(items.size) { index ->
            content(items[index])
        }
        if (isLoading && items.isNotEmpty()) {
            item(span = { GridItemSpan(columns) }) {
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
        observeLastVisibleItemAndLoadMoreCollect(
            state = lazyGridState,
            items = items,
            isLoading = isLoading,
            loadMoreItem = loadMoreItem
        )
    }

}

@Composable
fun <T> LazyHorizontalGrid(
    modifier: Modifier = Modifier,
    items: List<T>,
    rows: Int,
    isLoading: Boolean,
    loadMoreItem: () -> Unit = {},
    content: @Composable (T) -> Unit
) {
    val lazyGridState = rememberLazyGridState()

    LazyHorizontalGrid(
        rows = GridCells.Fixed(rows),
        state = lazyGridState,
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Add padding around the grid
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between columns
        verticalArrangement = Arrangement.spacedBy(16.dp) // Spacing between rows
    ) {
        items(items.size) { index ->
            content(items[index])
        }
        if (isLoading && items.isNotEmpty()) {
            item(span = { GridItemSpan(rows) }) {
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
        observeLastVisibleItemAndLoadMoreCollect(
            state = lazyGridState,
            items = items,
            isLoading = isLoading,
            loadMoreItem = loadMoreItem
        )
    }

}

private suspend fun <T> observeLastVisibleItemAndLoadMoreCollect(
    state: ScrollableState,
    items: List<T>,
    isLoading: Boolean,
    loadMoreItem: () -> Unit
) {
    when (state) {
        is LazyGridState -> {
            snapshotFlow { state.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
                .distinctUntilChanged()
                .collect { lastVisibleItemIndex ->
                    if (lastVisibleItemIndex != null && lastVisibleItemIndex == items.lastIndex && !isLoading) {
                        loadMoreItem.invoke()
                    }
                }
        }

        is LazyListState -> {
            snapshotFlow { state.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
                .distinctUntilChanged()
                .collect { lastVisibleItemIndex ->
                    if (lastVisibleItemIndex != null && lastVisibleItemIndex == items.lastIndex && !isLoading) {
                        loadMoreItem.invoke()
                    }
                }
        }
    }
}

