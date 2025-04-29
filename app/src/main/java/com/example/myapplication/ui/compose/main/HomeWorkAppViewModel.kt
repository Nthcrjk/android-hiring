package com.example.myapplication.ui.compose.main

import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.base.BaseViewModel
import com.example.myapplication.common.systems.network.SocketManager
import com.example.myapplication.common.systems.network.TestRequest
import com.example.myapplication.common.systems.notification.NotificationEvent
import com.example.myapplication.common.systems.notification.NotificationManager
import com.example.myapplication.common.systems.prefs.PrefsService
import com.example.myapplication.ui.compose.dialog.Gender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeWorkAppUiState(
    val isLoading: Boolean = false,
    val gender: Gender? = null,
    val age: Int? = null,
    val showDialog: Boolean = false,
)

@HiltViewModel
class HomeWorkAppViewModel @Inject constructor(
    notificationManager: NotificationManager,
    prefsService: PrefsService,
    val socketManager: SocketManager,
) : BaseViewModel<HomeWorkAppUiState>(
    notificationManager,prefsService
) {

    fun changeGender(
        gender: Gender
    ) {
        _state.update {
            it.copy(
                gender = gender
            )
        }
    }

    fun changeAge(
        age: Int
    ) {
        _state.update {
            it.copy(
                age = age
            )
        }
    }

    fun changeDialogState(
        boolean: Boolean
    ) {
        _state.update {
            it.copy(
                showDialog = boolean
            )
        }
    }
    fun connect() {
        viewModelScope.launch(Dispatchers.IO) {
            socketManager.connect()
        }
    }

    fun onContinueBtnClick() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (!state.value.isLoading) {
                    _state.update {
                        it.copy(isLoading = true)
                    }
                    socketManager.send(
                        TestRequest(
                            gender = state.value.gender?.value!!,
                            age = state.value.age!!
                        )
                    )
                    val result = socketManager.receive()
                    notificationManager.notify(
                        NotificationEvent.ShowToast(
                            if (result.allowed) "Успешно" else "Ошибка"
                        )
                    )
                    if (result.allowed) {
                        prefsService.gender = state.value.gender
                        prefsService.age = state.value.age
                        changeDialogState(false)
                    }
                    _state.update {
                        it.copy(isLoading = false)
                    }
                }
            } catch (e: Exception) {
                exceptionCatcher(e)
                _state.update {
                    it.copy(isLoading = false)
                }
            }
        }
    }

    override fun initUiState(): MutableStateFlow<HomeWorkAppUiState> {
        val startState = HomeWorkAppUiState()
        val result = startState.copy(
            gender = if (prefsService.gender != null) prefsService.gender else startState.gender,
            age = if (prefsService.age != null) prefsService.age else startState.age
        )
        return MutableStateFlow(result)
    }
}