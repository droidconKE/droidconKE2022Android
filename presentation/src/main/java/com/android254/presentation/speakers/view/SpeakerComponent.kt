package com.android254.presentation.speakers.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.models.Speaker

@Composable
fun SpeakerComponent(modifier: Modifier = Modifier, speaker: Speaker = Speaker()) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.smoke_white)
        )
    ) {
        Column(
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.smiling),
                contentDescription = "Speaker headshot"
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = "Harun Wangereka",
                style = TextStyle(
                    color = colorResource(id = R.color.blue),
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold))
                ),
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = "Quick fox jumped over the lazy dog",
                style = TextStyle(
                    color = colorResource(id = R.color.grey),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),// Extract the fonts or get them from chai system
                ),
            )
            Spacer(modifier = modifier.height(16.dp))
            OutlinedButton(
                onClick = { Unit },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.aqua)
                )
            ) {
                Text(
                    text = "Session",
                    color = colorResource(id = R.color.aqua),
                    fontFamily = FontFamily(Font(R.font.montserrat_semi_bold)),
                ) // TODO: Extract text
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
