package com.example.compose_app.loggedin.logic

import com.example.compose_app.loggedin.logic.LoggedInEffect.NavigateBack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoggedInViewModel(
    username: String,
    password: String,
    private val coroutineScope: CoroutineScope,
) {
    private val mutableUiState =
        MutableStateFlow(
            value = LoggedInUiState.initial(
                username = username,
                password = password,
            )
        )

    val uiState = mutableUiState.asStateFlow()

    private val mutableUiEffect = MutableSharedFlow<LoggedInEffect>()
    val uiEffect = mutableUiEffect.asSharedFlow()

    fun onBackButtonClicked() {
        coroutineScope.launch {
            mutableUiEffect.emit(NavigateBack)
        }
    }
}
