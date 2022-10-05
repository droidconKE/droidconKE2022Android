package com.android254.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.models.Speaker

@Composable
fun HomeSpeakerComponent(speaker: Speaker){
    Column(
        modifier = Modifier
            .height(110.dp)
            .width(90.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(speaker.imageUrl)
                .build(),
            placeholder = painterResource(R.drawable.smiling),
            contentDescription = stringResource(R.string.head_shot),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(7.dp)
                )
                .border(BorderStroke(2.dp, color = colorResource(id = R.color.cyan)))
                .height(72.dp)
                .width(72.dp),

            )
        Text(
            text = speaker.name,
            modifier = Modifier.padding(top = 7.dp),
            style = TextStyle(
                color = colorResource(id = R.color.dark),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_medium))
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun HomeSpeakerComponentPreview() {
    DroidconKE2022Theme {
        Surface(color = Color.White) {
            HomeSpeakerComponent(speaker = Speaker(name = "Harun Wangereka", bio = "Staff Engineer"))
        }
    }
}