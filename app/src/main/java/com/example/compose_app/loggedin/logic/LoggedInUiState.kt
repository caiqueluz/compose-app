package com.example.compose_app.loggedin.logic

data class LoggedInUiState(
    val usernameText: String,
    val passwordText: String,
) {
    companion object {
        fun initial(
            username: String,
            password: String,
        ) =
            LoggedInUiState(
                usernameText = username,
                passwordText = password,
            )
    }
}
