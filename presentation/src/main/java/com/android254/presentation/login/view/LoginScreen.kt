package com.android254.presentation.login.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun LoginScreen() {
    Text(text = "Login Screen")
}

@Preview
@Composable
fun LoginScreenPreview() {
    DroidconKE2022Theme {
        LoginScreen()
    }
}