/*
 * Copyright 2022 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.presentation.speakers.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.speakers.SpeakerViewModel

@Composable
fun SpeakersScreen(speakersViewModel: SpeakerViewModel = hiltViewModel()) {
    val speakers = speakersViewModel.getSpeakers()
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
<<<<<<< HEAD
                        text = stringResource(id = R.string.spekers_label),
=======
                        text = stringResource(id = R.string.speakers_label),
>>>>>>> 0afbeb1 (fix lint + clean up)
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        color = colorResource(id = R.color.dark)
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
    ) { paddingValues ->
        LazyVerticalGrid(

            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 80.dp, bottom = 16.dp)
        ) {
            items(speakers) {speaker->
                SpeakerComponent(speaker = speaker)
            }
        }
    }
}

@Preview
@Composable
fun SpeakersScreenPreview() {
    DroidconKE2022Theme {
        SpeakersScreen()
    }
}