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
package com.android254.presentation.about.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.android254.presentation.R
import com.android254.presentation.common.components.DroidconAppBarWithFeedbackButton
import com.android254.presentation.common.components.OrganizedBySection
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.models.OrganizingTeamMember
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun AboutScreen(
    aboutViewModel: AboutViewModel = hiltViewModel(),
) {
    val teamMembers: List<OrganizingTeamMember> = aboutViewModel.organizingTeamMembers.value
    val stakeHolderLogos = aboutViewModel.stakeHolderLogos.value

    Scaffold(
        topBar = {
            DroidconAppBarWithFeedbackButton(
                onButtonClick = {
                    // TODO navigate to feedbackScreen
                },
                userProfile = "https://media-exp1.licdn.com/dms/image/C4D03AQGn58utIO-x3w/profile-displayphoto-shrink_200_200/0/1637478114039?e=2147483647&v=beta&t=3kIon0YJQNHZojD3Dt5HVODJqHsKdf2YKP1SfWeROnI"
            )
        }
    ) { paddingValues ->

        Column(
            Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .testTag("about_screen")
        ) {
            AboutDroidConSection(droidconDesc = stringResource(id = R.string.about_droidcon))

            Spacer(modifier = Modifier.height(40.dp))

            OrganizingTeamSection(
                modifier = Modifier,
                organizingTeam = teamMembers,
                onClickMember = {
                    // TODO navigate to team screen
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            OrganizedBySection(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                organizationLogos = stakeHolderLogos
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun AboutDroidConSection(
    modifier: Modifier = Modifier,
    droidconDesc: String,
) {
    Column(
        modifier = modifier
    ) {

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.about_droidcon),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.about_droidcon_image),
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            text = stringResource(id = R.string.about),
            style = TextStyle(
                color = Color(0xFF000CEB),
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                lineHeight = 25.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            ),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            text = droidconDesc,
            style = TextStyle(
                color = Color(0xFF20201E),
                fontSize = 16.sp,
                lineHeight = 19.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_light)),
            ),
        )
    }
}

@Composable
fun OrganizingTeamSection(
    modifier: Modifier = Modifier,
    organizingTeam: List<OrganizingTeamMember>,
    onClickMember: (Int) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp)
            .testTag("organizing_team_section")
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.about_organizing_team),
            style = TextStyle(
                color = Color(0xFF000CEB),
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                lineHeight = 25.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            ),
        )

        Spacer(modifier = Modifier.height(40.dp))

        FlowRow(
            modifier = Modifier,
            mainAxisAlignment = MainAxisAlignment.SpaceBetween,
            mainAxisSize = SizeMode.Expand,
            mainAxisSpacing = 16.dp,
            crossAxisSpacing = 16.dp,
            lastLineMainAxisAlignment = MainAxisAlignment.Start
        ) {
            organizingTeam.forEach { teamMember ->
                OrganizingTeamComponent(
                    modifier = Modifier.width(99.dp),
                    teamMember = teamMember,
                    onClickMember = onClickMember,
                )
            }
        }
    }
}

@Preview
@Composable
fun AboutScreenPreview() {
    DroidconKE2022Theme {
        AboutScreen()
    }
}