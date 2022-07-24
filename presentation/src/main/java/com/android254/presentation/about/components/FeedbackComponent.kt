package com.android254.presentation.about.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeedbackComponent() {
    Row(
        modifier = Modifier
            .background(
                color = Color(0xFF00E2C3).copy(.21f),
                shape = RoundedCornerShape(10.dp)
            )
            .width(127.dp)
            .height(30.dp)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            Icons.Filled.Face,
            contentDescription = "feedback icon",
            modifier = Modifier.size(12.dp),
            colorFilter = ColorFilter.tint(color = Color.White)
        )

        Text(
            text = "Feedback",
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        )

        Icon(Icons.Filled.Send, contentDescription = "", modifier = Modifier.size(12.dp))

    }
}