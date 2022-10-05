package com.android254.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.models.Speaker
import com.android254.presentation.speakers.SpeakersViewModel
import okhttp3.internal.wait

@Composable
fun HomeSpeakersSection(speakers: List<Speaker>) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (titleText, viewAllBtn, speakersRow) = createRefs()
        Text(text = stringResource(id = R.string.speakers_label),
            style = TextStyle(
                color = colorResource(id = R.color.blue),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)
                )
            ),
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(speakersRow.top)
                })
        TextButton(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(viewAllBtn) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(speakersRow.top)
            }) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    /**
                     * TODO: Update the count: state
                     */
                    text = stringResource(R.string.view_all_label),
                    style = TextStyle(
                        color = colorResource(id = R.color.blue),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_semi_bold)
                        )
                    )
                )
                Spacer(modifier = Modifier.width(7.dp))
                Box(
                    modifier = Modifier
                        .height(22.dp)
                        .width(35.dp)
                        .background(
                            color = colorResource(id = R.color.blue_11),
                            shape = RoundedCornerShape(14.dp)
                        )
                ) {
                    Text(
                        text = "100", // Todo: Update this with state
                        modifier = Modifier.align(Alignment.Center),
                        style = TextStyle(
                            color = colorResource(id = R.color.blue),
                            fontSize = 10.sp,
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_regular)
                            )
                        ),
                    )
                }
            }
        }
        // TODO: fIX the scrolling and padding
        LazyRow(modifier = Modifier
            .padding(vertical = 22.dp)
            .constrainAs(speakersRow) {
                top.linkTo(titleText.bottom)
            }) {
            items(4) { index ->
                HomeSpeakerComponent(speaker = speakers[index])
            }
        }
    }
}

@Preview
@Composable
fun HomeSpeakersSectionPreview() {
    val viewModel = hiltViewModel<SpeakersViewModel>()
    Surface(color = Color.White) {
        HomeSpeakersSection(speakers = viewModel.getSpeakers())
    }

}

