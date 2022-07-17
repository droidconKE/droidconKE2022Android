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
package com.android254.presentation.sessions.view

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.common.components.EventDaySelectorButton
import com.android254.presentation.common.theme.DroidconKE2022Theme

data class EventDay(val date: String = "16th")

val eventDays = listOf<EventDay>(
    EventDay("16th"),
    EventDay("17th"),
    EventDay("18th"),
)

@Composable
fun SessionsScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    val showMySessions = remember {
        mutableStateOf(true)
    }
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            Row() {
                eventDays.forEachIndexed { index, eventDay ->
                    EventDaySelectorButton(
                        title = eventDay.date,
                        subtitle = "Day ${index + 1}",
                        onClick = { /*TODO*/ }) {

                    }
                    Spacer(Modifier.width(16.dp))
                }
            }
            Switch(checked = showMySessions.value, onCheckedChange = {
                showMySessions.value = it
            })
        }
    }
}

@Preview
@Composable
fun SessionsScreenPreview() {
    DroidconKE2022Theme {
        SessionsScreen()
    }
}