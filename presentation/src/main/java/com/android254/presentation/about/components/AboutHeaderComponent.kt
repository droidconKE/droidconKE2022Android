package com.android254.presentation.about.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun AboutHeaderComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        //replace with droidconKe logo
        Icon(
            Icons.Filled.Image,
            contentDescription = "droidconKe logo",
            modifier = Modifier
                .width(137.dp)
                .height(25.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FeedbackComponent()
            Image(
                Icons.Filled.Handyman,
                contentDescription = "profile image",
                modifier = Modifier
                    .size(30.dp)
                    .clip(
                        CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
        }
    }
}