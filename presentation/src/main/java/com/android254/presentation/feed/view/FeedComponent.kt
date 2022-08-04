package com.android254.presentation.feed.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun FeedComponent(modifier: Modifier, onClickItem: (Int) -> Unit) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = { onClickItem(1) },
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            val textFromNetwork = stringResource(id = R.string.placeholder_long_text)

            Text(
                text = textFromNetwork,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                textAlign = TextAlign.Start,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(6.dp)),
                imageVector = Icons.Rounded.Newspaper,
                contentDescription = textFromNetwork
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(
                    onClick = {
                        // ToDo: Intent to share post
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.share),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                        fontStyle = MaterialTheme.typography.labelLarge.fontStyle
                    )

                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = stringResource(id = R.string.share),
                        modifier = Modifier.padding(end = 8.dp),
                        tint = Color(0xFF673AB7)
                    )
                }

                Text(
                    text = "5 hours ago",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                    fontStyle = MaterialTheme.typography.labelLarge.fontStyle
                )
            }

        }
    }

}

@Preview
@Composable
fun Preview() {
    DroidconKE2022Theme {
        FeedComponent(modifier = Modifier) {

        }
    }
}