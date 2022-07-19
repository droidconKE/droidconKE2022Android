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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android254.presentation.R
import com.android254.presentation.common.components.EventDaySelectorButton
import com.android254.presentation.common.components.SessionsCard
import com.android254.presentation.common.theme.DroidconKE2022Theme

data class EventDay(val date: String = "16th")
data class Event(
    val startTime: String,
    val endTime: String,
    val title: String,
    val subtitle: String,
    val roomLabel: String?,
    val presenter: String?,
    val presenterPicture: String?,
    val isMarked: Boolean = false
)

val eventDays = listOf<EventDay>(
    EventDay("16th"),
    EventDay("17th"),
    EventDay("18th"),
)

val events = arrayListOf<Event>(
    Event(
        "09:00",
        "09:30",
        "Arrival",
        "Registration & Breakfast",
        null,
        null,
        null,
        false
    ),
    Event(
        "09:30",
        "10:00",
        "Opening",
        "Welcome & Keynote",
        "Room 1",
        "Dr. John Doe",
        null,
        false
    ),
    Event(
        "10:00",
        "10:30",
        "Android 254",
        "The community and the efforts",
        "Room 2",
        "Greg Dawson",
        null,
        false
    ),
    Event(
        "10:30",
        "11:00",
        "Break",
        "Lunch",
        null,
        null,
        null,
        false
    ),
    Event(
        "11:00",
        "11:30",
        "Session 1",
        "Session 1",
        "Room 3",
        "Michael Kimathi",
        null,
        false
    ),
)

@Composable
fun SessionsScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    val showMySessions = remember {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, end = 0.dp, top = 24.dp, bottom = 12.dp)
        ) {
            Row() {
                eventDays.forEachIndexed { index, eventDay ->
                    EventDaySelectorButton(
                        title = eventDay.date,
                        subtitle = "Day ${index + 1}",
                        onClick = { /*TODO*/ },
                        selected = index == 0
                    ) {
                    }
                    Spacer(Modifier.width(16.dp))
                }
            }
            Switch(checked = showMySessions.value, onCheckedChange = {
                showMySessions.value = it
            })
        }
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            itemsIndexed(events) { index, event ->
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                    SessionsCard(session = event)
                    if (index != events.size - 1) {
                        Box(
                            Modifier.padding(
                                start = 40.dp,
                                end = 0.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            )
                        ) {
                            Image(
                                painter = painterResource(id = if (index % 2 == 0) R.drawable.ic_green_session_card_spacer else R.drawable.ic_orange_session_card_spacer),
                                contentDescription = "spacer icon"
                            )
                        }
                    }
                }
            }
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