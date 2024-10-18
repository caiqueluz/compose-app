package com.example.compose_app.loggedin.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.compose_app.loggedin.logic.LoggedInEffect.NavigateBack
import com.example.compose_app.loggedin.logic.LoggedInViewModel

@Composable
fun LoggedInHost(
    modifier: Modifier = Modifier,
    username: String,
    password: String,
    navigateBack: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    val viewModel = remember {
        LoggedInViewModel(
            username = username,
            password = password,
            coroutineScope = coroutineScope,
        )
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                NavigateBack -> navigateBack()
            }
        }
    }

    BackHandler(
        onBack = viewModel::onBackButtonClicked,
    )

    val uiState by viewModel.uiState.collectAsState()

    LoggedInScreen(
        modifier = modifier,
        uiState = uiState,
    )
}
