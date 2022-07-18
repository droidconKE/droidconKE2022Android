package com.android254.presentation.sessions.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun SessionsScreen() {
    Text(text = "Sessions Screen")
}

@Preview
@Composable
fun SessionsScreenPreview() {
    DroidconKE2022Theme {
        SessionsScreen()
    }
}