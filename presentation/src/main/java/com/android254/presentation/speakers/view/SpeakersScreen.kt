package com.android254.presentation.speakers.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.models.Speaker
import com.android254.presentation.models.speakersList

@Composable
fun SpeakersScreen(speakers: List<Speaker>) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = "Speakers",
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular))
                    )
                },

                navigationIcon = {
                    IconButton(
                        onClick = { },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back_arrow),
                            contentDescription = stringResource(R.string.back_arrow_icon_description),
                            tint = colorResource(id = R.color.dark)
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = colorResource(id = R.color.dark),
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) {paddingValues ->
        LazyVerticalGrid(
            columns =  GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(16.dp)){
           items(speakers){speaker ->
               SpeakerComponent(speaker = speaker)
           }
        }

    }

}

@Preview
@Composable
fun SpeakersScreenPreview() {
    DroidconKE2022Theme {
        SpeakersScreen(speakersList)
    }
}