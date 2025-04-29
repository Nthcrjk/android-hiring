package com.example.myapplication.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.compose.home.HomeRoute
import com.example.myapplication.ui.compose.theme.HomeWorkTheme

@Preview
@Composable
fun HomeWorkApp() {
    HomeWorkTheme {
        HomeRoute()
    }
}