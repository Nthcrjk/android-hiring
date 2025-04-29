package com.example.myapplication.common.base

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.systems.NotificationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<S>(
    val notificationManager: NotificationManager
): ViewModel() {

    protected val _state: MutableStateFlow<S> = initUiState()
    val state = _state.asStateFlow()


    protected fun exceptionCatcher(e: Exception) {
        // TODO: Обработка исключений
    }


    protected abstract fun initUiState(): MutableStateFlow<S>

}