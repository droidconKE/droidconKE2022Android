package com.android254.presentation.about.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android254.presentation.R

@Composable
fun AboutComponent() {
    Text(
        text = "About",
        style = TextStyle(
            color = MaterialTheme.colorScheme.surfaceTint,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )
    )
    Text(
        text = stringResource(id = R.string.about_desc),
        style = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
    )
}