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

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.android254.presentation.R

data class SessionPresentationModel(
    val id: String,
    val sessionTitle: String,
    val sessionDescription: String,
    val sessionVenue: String,
    val sessionSpeakerImage: String,
    val sessionTime: String
)

@Composable
fun SessionsCard(sessionPresentationModel: SessionPresentationModel,onclick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(5),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        onClick = onclick
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(PaddingValues(top = 20.dp))
        ) {
            SessionTimeComponent("3:45PM")
            SessionDetails()
        }
    }
}

@Composable
fun RowScope.SessionTimeComponent(time: String) {
    val timeValue = mutableListOf<Char>()
    val meridian = mutableListOf<Char>()
    time.toList().reversed().forEach {
        if (!it.isDigit() && meridian.size != 2) {
            meridian.add(it)
        } else {
            timeValue.add(it)
        }
    }
    Column(
        modifier = Modifier
            .weight(0.15f)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = timeValue.reversed().joinToString(""),
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
        )
        Text(
            text = meridian.reversed().joinToString(""),
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
        )
    }
}

@Composable
fun RowScope.SessionDetails() {
    Column(
        modifier = Modifier
            .weight(0.85f)
            .padding(PaddingValues(start = 10.dp, end = 10.dp, bottom = 10.dp))
            .fillMaxHeight()
    ) {
        SessionTitleBlock()
        SessionsDescriptionComponent()
        TimeAndVenue()
        SessionPresenterComponents()
    }
}

@Composable
fun SessionTitleBlock() {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    ) {
        val (sessionTitle, starIcon) = createRefs()
        Text(
            text = "Keynote",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 18.sp
            ),
            modifier = Modifier.constrainAs(sessionTitle) {
                start.linkTo(parent.start)
            }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "star session",
            modifier = Modifier
                .size(21.dp)
                .constrainAs(starIcon) {
                    end.linkTo(parent.end)
                    top.linkTo(sessionTitle.top)
                    bottom.linkTo(sessionTitle.bottom)
                }
                .clickable(indication = null, interactionSource = interactionSource) {
                    Toast
                        .makeText(context, "Session has been starred", Toast.LENGTH_LONG)
                        .show()
                },
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun SessionsDescriptionComponent() {
    Text(
        text = "Community on a Global Scale",
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun TimeAndVenue() {
    Text(text = "9:00AM - 9:30AM | ROOM 1", style = MaterialTheme.typography.bodySmall)
}

@Composable
fun SessionPresenterComponents(sessionSpeakerImageUrl: String, sessionSpeakerName: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = sessionSpeakerImageUrl,
            contentDescription = "session speaker image",
            modifier = Modifier.size(30.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = sessionSpeakerName,
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary)
        )
    }
}