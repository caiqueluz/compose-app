package com.example.compose_app.loggedout.ui

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

object SecurePasswordVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val secureText =
            text
                .map { "•" }
                .joinToString(separator = "")

        return TransformedText(
            text = AnnotatedString(secureText),
            OffsetMapping.Identity,
        )
    }
}
