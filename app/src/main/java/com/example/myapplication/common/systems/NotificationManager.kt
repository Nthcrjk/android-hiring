package com.example.myapplication.common.systems

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

sealed interface NotificationEvent {
    object ShowAboutUserDialog : NotificationEvent
}

class NotificationManager() {
    private val _events = MutableSharedFlow<NotificationEvent>()
    val events = _events.asSharedFlow()

    suspend fun notify(event: NotificationEvent) {
        _events.emit(event)
    }
}