package com.example.compose_app.loggedout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_app.loggedout.logic.LoggedOutUiState
import com.example.compose_app.ui.theme.ComposeAppTheme

@Composable
fun LoggedOutScreen(
    modifier: Modifier = Modifier,
    uiState: LoggedOutUiState,
    onUsernameValueChanged: (String) -> Unit,
    onPasswordValueChanged: (String) -> Unit,
    onSubmitButtonClicked: () -> Unit,
) {
    Column(
        modifier =
        modifier
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        InputSection(
            labelText = "Username",
            currentText = uiState.usernameCurrentText,
            onValueChanged = onUsernameValueChanged,
        )

        Spacer(
            modifier = Modifier.height(16.dp),
        )

        InputSection(
            visualTransformation = SecurePasswordVisualTransformation,
            labelText = "Password",
            currentText = uiState.passwordCurrentText,
            onValueChanged = onPasswordValueChanged,
        )

        Spacer(
            modifier = Modifier.height(16.dp),
        )

        Button(
            onClick = onSubmitButtonClicked,
            enabled = uiState.isSubmitButtonEnabled,
        ) {
            Text(
                text = "Submit",
            )
        }
    }
}

@Composable
private fun InputSection(
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    labelText: String,
    currentText: String,
    onValueChanged: (String) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = labelText,
        )
        
        Spacer(
            modifier = Modifier.width(16.dp),
        )

        TextField(
            value = currentText,
            onValueChange = onValueChanged,
            placeholder = {
                Text(
                    text = "Write your $labelText here.",
                )
            },
            visualTransformation = visualTransformation,
        )
    }
}

@Preview
@Composable
private fun LoggedOutScreenPreview() {
    ComposeAppTheme {
        LoggedOutScreen(
            modifier = Modifier.fillMaxSize(),
            uiState =
                LoggedOutUiState(
                    usernameCurrentText = "",
                    passwordCurrentText = "",
                    isSubmitButtonEnabled = true,
                ),
            onUsernameValueChanged = {},
            onPasswordValueChanged = {},
            onSubmitButtonClicked = {},
        )
    }
}
