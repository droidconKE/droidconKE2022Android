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
package com.android254.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.android254.presentation.R
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

/**
 * Great alignment that matches the design but can not be scrolled within a column
 * */
@Composable
fun OrganizedBySection(
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
            text = stringResource(id = R.string.organized_by),
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

/**
 * Uses flow row but the alignment is not the best
 * */
@Composable
fun OrganizedBySection2(
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
            .padding(horizontal = 40.dp, vertical = 20.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.organized_by),
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

        FlowRow(
            modifier = Modifier,
            mainAxisAlignment = MainAxisAlignment.SpaceEvenly,
            mainAxisSize = SizeMode.Expand,
            mainAxisSpacing = 16.dp,
            crossAxisSpacing = 16.dp,
        ) {
            organizationLogos.forEach { logo ->
                Image(
                    modifier = Modifier.defaultMinSize(minWidth = 68.dp),
                    painter = painterResource(id = logo),
                    contentDescription = "Logo",
                )
            }
        }
    }
}

@Preview
@Composable
fun OrganizedByPreview() {
    DroidconKE2022Theme {
        OrganizedBySection(organizationLogos = stakeHolderLogos.value)
    }
}
@Preview
@Composable
fun OrganizedByPreview2() {
    DroidconKE2022Theme {
        OrganizedBySection2(organizationLogos = stakeHolderLogos.value)
    }
}
var stakeHolderLogos = mutableStateOf(
    listOf(
        R.drawable.ic_android254,
        R.drawable.kotlin_kenya_logo,
        R.drawable.k_logo,
        R.drawable.apps_lab_logo,
        R.drawable.early_camp_logo,
        R.drawable.ic_tiskos_logo,
    )
)