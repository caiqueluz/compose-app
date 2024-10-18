package com.example.compose_app.loggedin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_app.loggedin.logic.LoggedInUiState
import com.example.compose_app.ui.theme.ComposeAppTheme

@Composable
fun LoggedInScreen(
    modifier: Modifier = Modifier,
    uiState: LoggedInUiState,
) {
    Column(
        modifier =
        modifier
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        ValueSection(
            labelText = "Username",
            valueText = uiState.usernameText,
        )

        Spacer(
            modifier = Modifier.height(16.dp),
        )

        ValueSection(
            labelText = "Password",
            valueText = uiState.passwordText,
        )
    }
}

@Composable
private fun ValueSection(
    modifier: Modifier = Modifier,
    labelText: String,
    valueText: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = labelText,
        )

        Text(
            text = valueText,
        )
    }
}

@Preview
@Composable
private fun LoggedInScreenPreview() {
    ComposeAppTheme {
        LoggedInScreen(
            modifier = Modifier.fillMaxSize(),
            uiState =
                LoggedInUiState(
                    usernameText = "Fake Username",
                    passwordText = "fake-password-123"
                ),
        )
    }
}
