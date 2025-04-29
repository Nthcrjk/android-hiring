package com.example.myapplication.ui.compose.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.compose.theme.backgroundGreen

@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = backgroundGreen
    ) {
        Box(Modifier.padding(it)) {

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}