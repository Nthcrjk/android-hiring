package com.example.myapplication.ui.compose.main

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.common.systems.notification.NotificationEvent
import com.example.myapplication.ui.compose.dialog.CustomGenderAgeDialog
import com.example.myapplication.ui.compose.home.HomeRoute
import com.example.myapplication.ui.compose.theme.HomeWorkTheme
import kotlinx.coroutines.delay

@Preview
@Composable
fun HomeWorkApp() {

    val viewModel = hiltViewModel<HomeWorkAppViewModel>()
    val state = viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.notificationManager.events.collect {
            when(it) {
                NotificationEvent.ShowAboutUserDialog -> {
                    viewModel.changeDialogState(true)
                }

                is NotificationEvent.ShowToast -> {
                    Toast.makeText(context, it.text, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.connect()
        delay(1000)
        viewModel.notificationManager.notify(NotificationEvent.ShowAboutUserDialog)
    }

    HomeWorkTheme {
        if (state.value.showDialog) {
            CustomGenderAgeDialog(
                username = "Алекс",
                state.value.gender,
                state.value.age,
                {
                    viewModel.changeGender(it)
                },
                {
                    viewModel.changeAge(it)
                },
                {
                    viewModel.onContinueBtnClick()
                },
                onDismissRequest = {
                    viewModel.changeDialogState(false)
                }
            )
        }
        Box {
            HomeRoute()
        }
    }
}