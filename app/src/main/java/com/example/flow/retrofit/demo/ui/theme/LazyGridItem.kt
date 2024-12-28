package com.example.flow.retrofit.demo.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GridItem(item: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f), // Make the grid item square
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Item $item")
        }
    }
}