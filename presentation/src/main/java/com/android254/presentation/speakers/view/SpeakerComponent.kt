package com.android254.presentation.speakers.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults.FloatingActionButtonElevation.elevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.models.Speaker

@Composable
fun SpeakerComponent(
    modifier: Modifier = Modifier,
    speaker: Speaker = Speaker(name = "ABC", bio = "A quick brown fox ....")
) {
    Card(
        modifier = modifier.padding(7.dp).height(350.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.smoke_white)
        )
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(speaker.imageUrl)
                    .build(),
                placeholder = painterResource(R.drawable.smiling),
                contentDescription = stringResource(R.string.headshot),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(BorderStroke(2.5.dp, color = colorResource(id = R.color.cyan)))
                    .height(120.dp)
                    .width(120.dp)
            )

            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = speaker.name,
                style = TextStyle(
                    color = colorResource(id = R.color.blue),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold))
                ),
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = speaker.bio,
                style = TextStyle(
                    color = colorResource(id = R.color.grey),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),// Extract the fonts or get them from chai system
                ),
            )
            Spacer(modifier = modifier.height(20.dp))
            OutlinedButton(
                onClick = { Unit },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.aqua)
                )
            ) {
                Text(
                    text = stringResource(R.string.sessionLabel),
                    color = colorResource(id = R.color.aqua),
                    fontFamily = FontFamily(Font(R.font.montserrat_semi_bold)),
                )
            }
        }
    }

}

@Preview
@Composable
fun SpeakerComponentPreview() {
    DroidconKE2022Theme {
        SpeakerComponent()
    }
}
