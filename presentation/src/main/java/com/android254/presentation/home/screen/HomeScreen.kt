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
package com.android254.presentation.home.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.home.components.HomeBannerSection
import com.android254.presentation.home.components.HomeSpeakersSection
import com.android254.presentation.home.viewmodel.HomeViewModel
import com.android254.presentation.speakers.SpeakersViewModel
import com.droidconke.chai.atoms.type.MontserratSemiBold

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    speakersViewModel: SpeakersViewModel = hiltViewModel()
) {
    val homeViewState = homeViewModel.viewState
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.home_header_welcome_label),
            modifier = Modifier.testTag("home_header"),
            fontFamily = MontserratSemiBold,
            fontSize = 16.sp
        )
        HomeBannerSection(homeViewState)
        HomeSpeakersSection(speakers = speakersViewModel.getSpeakers())
        Spacer(modifier = Modifier.fillMaxSize())

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    DroidconKE2022Theme {
        Surface(color = Color.White) {
            HomeScreen()
        }
    }
}