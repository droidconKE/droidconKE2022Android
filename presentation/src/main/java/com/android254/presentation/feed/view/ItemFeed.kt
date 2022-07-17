package com.android254.presentation.feed.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun ItemFeed(modifier: Modifier, onClickItem: (Int) -> Unit) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { onClickItem(1) },
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Lorem Ipsum",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(6.dp)),
            painter = painterResource(id = androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha),
            contentDescription = ""
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextButton(
                onClick = {
                    // ToDo: Intent to share post
                }
            ) {
                Text(text = "Share")

                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp),
                    tint = Color(0xFFCC3333)
                )
            }

            Text(text = "5 hours ago")
        }

    }

}

@Preview
@Composable
fun Preview() {
    DroidconKE2022Theme {
        ItemFeed(modifier = Modifier) {

        }
    }
}