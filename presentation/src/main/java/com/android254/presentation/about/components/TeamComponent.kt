package com.android254.presentation.about.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PropaneTank
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TeamComponent(text: String, index: Int, subTitle: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 20.dp)
            .widthIn(min = 99.dp, max = 140.dp)
    ) {

        Image(
            Icons.Filled.PropaneTank,
            contentDescription = "About image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(99.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(width = 1.dp, color = Color(0xFF7DE1C3), shape = RoundedCornerShape(12.dp))
        )
        Text(
            text = "${text}$index",
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Text(
            text = "${subTitle}$index",
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}