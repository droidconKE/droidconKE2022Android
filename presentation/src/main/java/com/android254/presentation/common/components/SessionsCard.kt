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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android254.presentation.R

@Composable
fun SessionsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(5),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(Modifier.fillMaxSize().padding(PaddingValues(top = 20.dp))) {
            SessionTimeComponent()
            SessionDetails()
        }
    }
}

@Composable
fun RowScope.SessionTimeComponent() {
    Column(
        modifier = Modifier.weight(0.15f).fillMaxHeight(),
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "8:00")
        Text(text = "AM")
    }
}

@Composable
fun RowScope.SessionDetails() {
    Column(
        modifier = Modifier.weight(0.85f).padding(PaddingValues(horizontal = 10.dp)).fillMaxHeight()
    ) {
        SessionTitleBlock()
        SessionsDescriptionComponent()
        TimeAndVenue()
        SessionPresenterComponents()
    }
}

@Composable
fun SessionTitleBlock() {
    Row {
        Text(text = "Keynote")
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "star session",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun SessionsDescriptionComponent() {
    Text(
        text = "Community on a Global Scale that impacts us as devs",
    )
}

@Composable
fun TimeAndVenue() {
    Text(text = "9:00AM - 9:30AM | ROOM 1")
}

@Composable
fun SessionPresenterComponents() {
    Row {
        Icon(painter = painterResource(id = R.drawable.ic_baseline_android_24), contentDescription = "session topic")
    }
    Text(text = "Omolara Adejuwon")
}