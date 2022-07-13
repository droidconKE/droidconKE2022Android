package com.android254.presentation.common.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun DroidconAppBar() {
    SmallTopAppBar(title = { Text("DroidconKE 22") })
}

@Preview
@Composable
fun DroidconAppBarPreview() {
    DroidconKE2022Theme {
        DroidconAppBar()
    }
}