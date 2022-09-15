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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.models.OrganizingTeamMember
import com.android254.presentation.models.organizingTeamMembers

@Composable
fun AboutScreen() {

    Column(Modifier) {
        AboutDroidConSection(droidconDesc = stringResource(id = R.string.about_droidcon))

        Spacer(modifier = Modifier.height(40.dp))

        OrganizingTeamSection(
            modifier = Modifier,
            organizingTeam = organizingTeamMembers,
            onClickMember = {
                // TODO navigate to team screen
            }
        )
        Spacer(modifier = Modifier.height(40.dp))

        OrganizingStakeHoldersSection(organizationLogos = stakeHolderLogos)
    }
}

@Composable
fun AboutDroidConSection(
    modifier: Modifier = Modifier,
    droidconDesc: String,
) {
    Column(
        modifier = modifier
            .background(Color(0xFFFFFFFF))
    ) {

        Image(
            painter = painterResource(id = R.drawable.about_droidcon),
            contentScale = ContentScale.Fit,
            contentDescription = "Logo",
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
            .background(Color(0xFFFFFFFF))
            .padding(start = 20.dp, end = 20.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.organizing_team),
            style = TextStyle(
                color = Color(0xFF000CEB),
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                lineHeight = 25.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            ),
        )

        Spacer(modifier = Modifier.height(40.dp))

        LazyVerticalGrid(
            modifier = Modifier,
            columns = GridCells.Adaptive(102.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(organizingTeam) { teamMember ->
                OrganizingTeamComponent(
                    teamMember = teamMember,
                    onClickMember = onClickMember,
                )
            }
        }
    }
}

@Composable
fun OrganizingStakeHoldersSection(
    modifier: Modifier = Modifier,
    organizationLogos: List<Int>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 80.dp, vertical = 20.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.organizing_stake_holders),
            style = TextStyle(
                color = Color(0xFF000CEB),
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                lineHeight = 25.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            ),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(40.dp))

        LazyVerticalGrid(
            modifier = Modifier,
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            items(organizationLogos) { logo ->
                Image(
                    painter = painterResource(id = logo),
                    contentDescription = "Logo",
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

var stakeHolderLogos = listOf(
    R.drawable.ic_android254,
    R.drawable.kotlin_kenya_logo,
    R.drawable.k_logo,
    R.drawable.apps_lab_logo,
    R.drawable.early_camp_logo,
    R.drawable.ic_tiskos_logo,
)