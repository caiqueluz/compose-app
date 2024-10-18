package com.example.compose_app.root

sealed class AppScreen {
    data object LoggedIn : AppScreen()

    data object LoggedOut : AppScreen()
}
