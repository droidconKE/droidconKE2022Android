package com.android254.presentation.feed.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun FeedScreen() {
    Text(text = "Feed Screen")
}

@Preview
@Composable
fun FeedScreenPreview() {
    DroidconKE2022Theme {
        FeedScreen()
    }
}