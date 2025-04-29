package com.example.myapplication.ui.compose.main

import com.example.myapplication.common.base.BaseViewModel
import com.example.myapplication.common.systems.NotificationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

data class HomeWorkAppUiState(
    val isLoading: Boolean = false
)

@HiltViewModel
class HomeWorkAppViewModel @Inject constructor(
    notificationManager: NotificationManager
) : BaseViewModel<HomeWorkAppUiState>(
    notificationManager
) {
    override fun initUiState(): MutableStateFlow<HomeWorkAppUiState> {
        return MutableStateFlow(HomeWorkAppUiState())
    }
}