package com.example.compose_app.loggedout.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.compose_app.loggedout.logic.LoggedOutEffect.NavigateToLoggedInScreen
import com.example.compose_app.loggedout.logic.LoggedOutViewModel

@Composable
fun LoggedOutHost(
    modifier: Modifier = Modifier,
    navigateToLoggedInScreen: (username: String, password: String) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    val viewModel = remember {
        LoggedOutViewModel(
            coroutineScope = coroutineScope,
        )
    }

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                is NavigateToLoggedInScreen -> {
                    navigateToLoggedInScreen(
                        effect.username,
                        effect.password,
                    )
                }
            }
        }
    }

    LoggedOutScreen(
        modifier = modifier,
        uiState = uiState,
        onUsernameValueChanged = viewModel::onUsernameValueChanged,
        onPasswordValueChanged = viewModel::onPasswordValueChanged,
        onSubmitButtonClicked = viewModel::onSubmitButtonClicked,
    )
}
