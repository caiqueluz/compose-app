package com.example.compose_app.loggedout.logic

import com.example.compose_app.loggedout.logic.LoggedOutEffect.NavigateToLoggedInScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoggedOutViewModel(
    private val coroutineScope: CoroutineScope,
) {
    private val mutableUiState = MutableStateFlow(value = LoggedOutUiState.INITIAL)
    val uiState = mutableUiState.asStateFlow()

    private val mutableUiEffect = MutableSharedFlow<LoggedOutEffect>()
    val uiEffect = mutableUiEffect.asSharedFlow()

    private var username = ""
    private var password = ""

    fun onUsernameValueChanged(newValue: String) {
        username = newValue

        updateUiState()
    }

    fun onPasswordValueChanged(newValue: String) {
        password = newValue

        updateUiState()
    }

    fun onSubmitButtonClicked() {
        coroutineScope.launch {
            val effect =
                NavigateToLoggedInScreen(
                    username = username,
                    password = password,
                )

            mutableUiEffect.emit(effect)
        }
    }

    private fun updateUiState() {
        mutableUiState.update {
            LoggedOutUiState(
                usernameCurrentText = username,
                passwordCurrentText = password,
                isSubmitButtonEnabled = isLoginAttemptValid(),
            )
        }
    }

    private fun isLoginAttemptValid(): Boolean =
        username.isNotEmpty()
                && username.isNotBlank()
                && password.isNotEmpty()
                && password.isNotBlank()
}
