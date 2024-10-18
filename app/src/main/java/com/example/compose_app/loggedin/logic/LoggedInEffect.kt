package com.example.compose_app.loggedin.logic

sealed class LoggedInEffect {
    data object NavigateBack : LoggedInEffect()
}
