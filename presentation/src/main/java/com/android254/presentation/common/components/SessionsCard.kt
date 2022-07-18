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

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.common.theme.Montserrat
import com.android254.presentation.sessions.view.Event

@Composable
fun SessionsCard(session: Event) {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 36.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(horizontal = 17.dp, vertical = 21.dp)
        ) {
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = session.startTime,
                    style = TextStyle(fontSize = 18.sp, fontFamily = Montserrat)
                )
                Text(text = "AM")
            }
            Column(
                Modifier
                    .weight(1f)
                    .padding(start = 24.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
            ) {
                Text(
                    text = session.title,
                    style = TextStyle(
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        fontFamily = Montserrat
                    )
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = session.subtitle,
                    style = TextStyle(fontSize = 16.sp, fontFamily = Montserrat)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    Text(text = "9.30AM - 10:15AM")
                    Text(text = "|")
                    Text(text = "ROOM 1")
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Android, "", tint  = MaterialTheme.colorScheme.primary)
                    Text(text = "Omolara Adejuwon", fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
                }

            }
            Icon(Icons.Filled.StarBorder, "")
        }
    }
}