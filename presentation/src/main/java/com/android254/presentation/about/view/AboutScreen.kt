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

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.R

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(.6f))
            .padding(top = 13.dp, bottom = 45.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        aboutHeaderComponent()
        Image(
            Icons.Filled.PropaneTank,
            contentDescription = "About image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(235.dp)
        )

        aboutBody()

    }
}


@Composable
fun aboutBody() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 13.dp, end = 5.dp),
        verticalArrangement = Arrangement.spacedBy(23.dp)
    ) {


        aboutComponent()
        organizingTeamComponent()
        organisedByComponent()


    }
}

@Composable
fun organisedByComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 228.dp, max = 400.dp)
            .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(top = 20.dp, bottom = 12.dp),
        verticalArrangement = Arrangement.spacedBy(34.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Organised by;",
            style = TextStyle(
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        )


        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 228.dp, max = 400.dp)
                .padding(horizontal = 56.dp)
        ) {

            repeat(5) { index ->
                items(count = index) {
                    Image(
                        Icons.Filled.PropaneTank,
                        contentDescription = "company logos",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .size(40.dp),
                        colorFilter = ColorFilter.tint(color = Color.Green)
                    )
                }
            }

        }
    }

}

@Composable
fun aboutComponent() {
    Text(
        text = "About",
        style = TextStyle(
            color = Color(0xFF7DE1C3),
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal
        )
    )

    Text(
        text = "Droidcon is a global conference focused on the engineering of Android applications. Droidcon provides a forum for developers to network with other developers, share techniques, announce apps and products, and to learn and teach.\n\nThis two-day developer focused gathering will be held in Nairobi Kenya on August 6th to 8th 2020 and will be the largest of its kind in Africa.\n\nIt will have workshops and codelabs focused on the building of Android applications and will give participants an excellent chance to learn about the local Android development ecosystem, opportunities and services as well as meet the engineers and companies who work on them.",
        style = TextStyle(
            color = Color(0xFFFFFFFF),
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )
    )
}

@Composable
fun organizingTeamComponent() {
    Text(
        text = "Organizing Team",
        style = TextStyle(
            color = Color(0xFF7DE1C3),
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 10.dp, max = 600.dp)
    ) {

        repeat(5) { index ->
            items(count = index) {
                teamComponent(text = "text", index = index, subTitle = "Sub title")
            }
        }

    }
}

@Composable
fun teamComponent(text: String, index: Int, subTitle: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 20.dp)
            .widthIn(min = 99.dp, max = 140.dp)
    ) {

        Image(
            Icons.Filled.PropaneTank,
            contentDescription = "About image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(99.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(width = 1.dp, color = Color(0xFF7DE1C3), shape = RoundedCornerShape(12.dp))
        )
        Text(
            text = "${text}$index",
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Text(
            text = "${subTitle}$index",
            style = TextStyle(
                color = Color(0xFFB1B1B1),
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

data class OrganizingTeamPojo(
    val name: String,
    val subTitle: String
)

@Composable
fun aboutHeaderComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        //replace with droidconKe logo
        Icon(
            Icons.Filled.Image,
            contentDescription = "droidconKe logo",
            modifier = Modifier
                .width(137.dp)
                .height(25.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            feedbackComponent()
            Image(
                Icons.Filled.Handyman,
                contentDescription = "profile image",
                modifier = Modifier
                    .size(30.dp)
                    .clip(
                        CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun feedbackComponent() {
    Row(
        modifier = Modifier
            .background(
                color = Color(0xFF00E2C3).copy(.21f),
                shape = RoundedCornerShape(10.dp)
            )
            .width(127.dp)
            .height(30.dp)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            Icons.Filled.Face,
            contentDescription = "feedback icon",
            modifier = Modifier.size(12.dp),
            colorFilter = ColorFilter.tint(color = Color.White)
        )

        Text(
            text = "Feedback",
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        )

        Icon(Icons.Filled.Send, contentDescription = "", modifier = Modifier.size(12.dp))


    }
}

@Preview
@Composable
fun AboutScreenPreview() {
    DroidconKE2022Theme {
        AboutScreen()

    }
}