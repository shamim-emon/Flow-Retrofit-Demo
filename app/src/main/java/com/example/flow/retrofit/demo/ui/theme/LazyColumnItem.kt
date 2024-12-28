package com.example.flow.retrofit.demo.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flow.retrofit.demo.model.ApiUser

@Composable
fun LazyColumnItem(
    user: ApiUser,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "ID: ${user.id}")
            Text("Name: ${user.name}")
            Text("Email: ${user.email}")

        }
    }

}

@Preview
@Composable
private fun LazyColumnItemPreview() {
    FlowRetrofitDemoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LazyColumnItem(
                user = ApiUser(name = "Some Name", email = "email1233@gmail.com"),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}