package com.android254.presentation.about.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PropaneTank
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrganisedByComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 228.dp, max = 400.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceTint,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(top = 20.dp, bottom = 12.dp),
        verticalArrangement = Arrangement.spacedBy(34.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Organised by;",
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 228.dp, max = 400.dp)
                .padding(horizontal = 56.dp)
        ) {

            repeat(5) { index ->
                items(count = index) {
                    Image(
                        Icons.Filled.PropaneTank,
                        contentDescription = "company logos",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .size(40.dp),
                        colorFilter = ColorFilter.tint(color = Color.Green)
                    )
                }
            }
        }
    }
}