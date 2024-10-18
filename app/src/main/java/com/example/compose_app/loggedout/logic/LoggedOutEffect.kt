package com.example.compose_app.loggedout.logic

sealed class LoggedOutEffect {
    data class NavigateToLoggedInScreen(
        val username: String,
        val password: String,
    ) : LoggedOutEffect()
}
