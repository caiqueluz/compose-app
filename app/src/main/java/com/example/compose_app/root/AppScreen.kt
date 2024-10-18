package com.example.compose_app.root

sealed class AppScreen {
    data class LoggedIn(
        val username: String,
        val password: String,
    ) : AppScreen()

    data object LoggedOut : AppScreen()
}
