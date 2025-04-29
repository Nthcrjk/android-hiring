package com.example.myapplication.ui.compose.main

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.common.systems.NotificationEvent
import com.example.myapplication.ui.compose.dialog.CustomGenderAgeDialog
import com.example.myapplication.ui.compose.home.HomeRoute
import com.example.myapplication.ui.compose.theme.HomeWorkTheme
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@Preview
@Composable
fun HomeWorkApp() {

    val viewModel = hiltViewModel<HomeWorkAppViewModel>()

    var showDialog by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        viewModel.notificationManager.events.collect {
            when(it) {
                NotificationEvent.ShowAboutUserDialog -> {
                    showDialog = true
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        delay(1000)
        viewModel.notificationManager.notify(NotificationEvent.ShowAboutUserDialog)
    }

    HomeWorkTheme {
        if (showDialog) {
            CustomGenderAgeDialog(
                username = "Алекс",
                onDismissRequest = {
                    showDialog = false
                }
            )
        }
        Box {
            HomeRoute()
        }
    }
}