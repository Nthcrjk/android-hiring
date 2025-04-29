package com.example.myapplication.ui.compose.home

import com.example.myapplication.common.base.BaseViewModel
import com.example.myapplication.common.systems.NotificationManager
import kotlinx.coroutines.flow.MutableStateFlow

data class HomeUiState(
    val isLoading: Boolean = false
)

class HomeViewModel(
    notificationManager: NotificationManager
) : BaseViewModel<HomeUiState>(notificationManager) {
    override fun initUiState(): MutableStateFlow<HomeUiState> {
        return MutableStateFlow(HomeUiState())
    }
}