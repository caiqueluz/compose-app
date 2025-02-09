package com.example.compose_app.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.compose_app.loggedin.ui.LoggedInHost
import com.example.compose_app.loggedout.ui.LoggedOutHost
import com.example.compose_app.root.AppScreen.LoggedIn
import com.example.compose_app.root.AppScreen.LoggedOut

@Composable
fun RootHost(
    modifier: Modifier = Modifier,
) {
    var currentScreen: AppScreen by remember {
        mutableStateOf(LoggedOut)
    }

    var currentUsername by remember {
        mutableStateOf("")
    }

    var currentPassword by remember {
        mutableStateOf("")
    }

    when (currentScreen) {
        is LoggedIn -> {
            LoggedInHost(
                modifier = modifier,
                username = currentUsername,
                password = currentPassword,
                navigateBack = {
                    currentScreen = LoggedOut
                }
            )
        }

        is LoggedOut -> {
            LoggedOutHost(
                modifier = modifier,
                username = currentUsername,
                password = currentPassword,
                navigateToLoggedInScreen = { username, password ->
                    currentUsername = username
                    currentPassword = password

                    currentScreen = LoggedIn
                }
            )
        }
    }
}
