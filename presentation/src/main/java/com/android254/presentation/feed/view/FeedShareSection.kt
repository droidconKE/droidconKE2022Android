package com.android254.presentation.feed.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun FeedShareSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextButton(
                onClick = {
                }
            ) {
                Text(
                    text = stringResource(id = R.string.share),
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                    fontStyle = MaterialTheme.typography.labelLarge.fontStyle
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = stringResource(id = R.string.share),
                    modifier = Modifier.padding(start = 8.dp),
                    tint = Color.Black
                )
            }

            Text(
                text = "CANCEL",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.labelLarge.fontSize,
                fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                fontStyle = MaterialTheme.typography.labelLarge.fontStyle
            )
        }

        val platforms = mapOf(
            "Twitter" to R.drawable.ic_whatsapp,
            "Facebook" to R.drawable.ic_whatsapp,
            "WhatsApp" to R.drawable.ic_whatsapp,
            "Telegram" to R.drawable.ic_telegram
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(platforms.toList()) { platform ->
                    PlatformButton(platform = platform.first, icon = platform.second)
                }
            }
        )
    }
}

@Composable
fun PlatformButton(platform: String, icon: Int) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = R.string.share),
            tint = Color.Black
        )
        Text(
            text = platform,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlatformButtonPreview() {
    DroidconKE2022Theme {
        PlatformButton("Twitter", R.drawable.ic_whatsapp)
    }
}

@Preview(showBackground = true)
@Composable
fun PFeedShareSectionPreview() {
    DroidconKE2022Theme {
        FeedShareSection()
    }
}