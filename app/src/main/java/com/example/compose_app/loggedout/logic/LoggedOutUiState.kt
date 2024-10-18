package com.example.compose_app.loggedout.logic

data class LoggedOutUiState(
    val usernameCurrentText: String,
    val passwordCurrentText: String,
    val isSubmitButtonEnabled: Boolean,
) {
    companion object {
        val INITIAL =
            LoggedOutUiState(
                usernameCurrentText = "",
                passwordCurrentText = "",
                isSubmitButtonEnabled = false,
            )
    }
}
