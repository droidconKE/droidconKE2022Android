package com.android254.presentation.about.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun AboutScreen() {
    Text(text = "About Screen")
}

@Preview
@Composable
fun AboutScreenPreview() {
    DroidconKE2022Theme {
        AboutScreen()
    }
}