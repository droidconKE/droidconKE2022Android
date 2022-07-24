package com.android254.presentation.about.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OrganizingTeamComponent() {
    Text(
        text = "Organizing Team",
        style = TextStyle(
            color = MaterialTheme.colorScheme.surfaceTint,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 10.dp, max = 600.dp)
    ) {

        repeat(5) { index ->
            items(count = index) {
                TeamComponent(text = "text", index = index, subTitle = "Sub title")
            }
        }
    }
}