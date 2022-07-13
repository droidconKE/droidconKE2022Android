package com.android254.presentation.home.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun HomeScreen() {
    Text(text = "Home Screen")
}

@Preview
@Composable
fun HomeScreenPreview() {
    DroidconKE2022Theme {
        HomeScreen()
    }
}