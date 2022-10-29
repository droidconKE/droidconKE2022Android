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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.android254.presentation.R
import com.android254.presentation.common.components.DroidconAppBarWithFilter
import com.android254.presentation.common.components.EventDaySelectorButton
import com.android254.presentation.common.components.MultiToggleButton
import com.android254.presentation.common.components.SessionsCard
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.common.theme.Montserrat
import com.android254.presentation.models.SessionPresentationModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs

val events = arrayListOf<SessionPresentationModel>()

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SessionsScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    val showMySessions = remember {
        mutableStateOf(false)
    }

    val isSessionLayoutList = rememberSaveable {
        mutableStateOf(true)
    }

    val isFilterActive = rememberSaveable {
        mutableStateOf(true)
    }

    val isFilterDialogOpen = rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            DroidconAppBarWithFilter(
                isListActive = isSessionLayoutList.value,
                onListIconClick = {
                    isSessionLayoutList.value = true
                },
                onAgendaIconClick = {
                    isSessionLayoutList.value = false
                },
                isFilterActive = isFilterActive.value,
                onFilterButtonClick = {
                    isFilterDialogOpen.value = true
                }
            )
        }
    ) { paddingValues ->

        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, end = 0.dp, top = 5.dp, bottom = 12.dp)
            ) {
                /**
                 * Removed the dummy loop for the lint check
                 */
                Row() {
                    EventDaySelectorButton(
                        title = "16th",
                        subtitle = "Day 1",
                        onClick = { /*TODO*/ },
                        selected = true
                    ) {
                    }
                    Spacer(Modifier.width(16.dp))
                    EventDaySelectorButton(
                        title = "17th",
                        subtitle = "Day 2",
                        onClick = { /*TODO*/ },
                        selected = false
                    ) {
                    }
                    Spacer(Modifier.width(16.dp))
                    EventDaySelectorButton(
                        title = "",
                        subtitle = "Day 3",
                        onClick = { /*TODO*/ },
                        selected = false
                    ) {
                    }
                    Spacer(Modifier.width(16.dp))
                }
                Switch(checked = showMySessions.value, onCheckedChange = {
                    showMySessions.value = it
                    isFilterActive.value = !it
                })
            }
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                itemsIndexed(events) { index, event ->
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                        SessionsCard(session = event, onclick = {})
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
            if (isFilterDialogOpen.value) {
                Dialog(
                    properties = DialogProperties(
                        usePlatformDefaultWidth = false,
                        dismissOnClickOutside = true
                    ),
                    onDismissRequest = {
                        isFilterDialogOpen.value = false
                    }
                ) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        Color.Cyan
                                    )
                            ) {
                                Spacer(Modifier.weight(1f))
                                TextButton(onClick = { isFilterDialogOpen.value = false }) {
                                    Text(text = "Cancel")
                                }
                            }

                            Column(
                                Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                            ) {
                                Text(text = "Level", style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Montserrat
                                ))
                                MultiToggleButton(
                                    currentSelection = "Beginner",
                                    toggleStates = arrayOf("Beginner", "Intermediate", "Expert"),
                                    onToggleChange = {}
                                )
                            }
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