package com.android254.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun DroidconAppBarWithFeedbackButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 19.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.droidcon_logo),
            contentDescription = "DroidCon logo"
        )
        Spacer(modifier = Modifier.weight(1f))

        FeedbackButton(onButtonClick = onButtonClick)

        Spacer(modifier = Modifier.width(15.dp))

        Image(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.about_droidcon),
            contentDescription = "User profile",
            contentScale = ContentScale.Crop,

        )
    }
}

@Composable
fun FeedbackButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color(0xFF00E2C3).copy(alpha = 0.21f),
            )
            .clickable(onClick = onButtonClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_feedback_emoji),
            contentDescription = null
        )

        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.feedback),
            style = TextStyle(
                color = Color(0xFF20201E),
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                lineHeight = 15.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            ),
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_send_icon),
            contentDescription = null,
            tint = Color(0xFF00E2C3),
        )
    }
}

@Preview
@Composable
fun Preview() {
    DroidconKE2022Theme {
        DroidconAppBarWithFeedbackButton(onButtonClick = {})
    }
}