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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarOutline
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.android254.presentation.models.SessionPresentationModel

@Composable
fun SessionsCard(session: SessionPresentationModel, onclick: () -> Unit) {
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
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(PaddingValues(top = 20.dp))
        ) {
            SessionTimeComponent(
                session.sessionStartTime,
                session.amOrPm
            )
            SessionDetails(session = session)
        }
    }
}

@Composable
fun RowScope.SessionTimeComponent(sessionStartTime: String, sessionAmOrPm: String) {
    Column(
        modifier = Modifier
            .weight(0.15f),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = sessionStartTime,
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
        )
        Text(
            text = sessionAmOrPm,
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
        )
    }
}

@Composable
fun RowScope.SessionDetails(session: SessionPresentationModel) {
    Column(
        modifier = Modifier
            .weight(0.85f)
            .padding(PaddingValues(start = 10.dp, end = 10.dp, bottom = 10.dp))
    ) {
        SessionTitleComponent(session.sessionTitle, session.isStarred)
        SessionsDescriptionComponent(session.sessionDescription)
        Spacer(modifier = Modifier.height(12.dp))
        TimeAndVenueComponent(session)
        Spacer(modifier = Modifier.height(4.dp))
        SessionPresenterComponents(
            sessionSpeakerImageUrl = session.sessionSpeakerImage,
            sessionSpeakerName = session.sessionSpeakerName
        )
    }
}

@Composable
fun SessionTitleComponent(sessionTitle: String, sessionIsStarred: Boolean) {
    val interactionSource = remember { MutableInteractionSource() }
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    ) {
        val (sessionTitleRef, starIcon) = createRefs()
        Text(
            text = sessionTitle,
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 18.sp
            ),
            modifier = Modifier.constrainAs(sessionTitleRef) {
                start.linkTo(parent.start)
            }
        )

        Icon(
            imageVector = if (sessionIsStarred) Icons.Rounded.StarOutline else Icons.Rounded.Star,
            contentDescription = "star session",
            modifier = Modifier
                .size(30.dp)
                .constrainAs(starIcon) {
                    end.linkTo(parent.end)
                    top.linkTo(sessionTitleRef.top)
                    bottom.linkTo(sessionTitleRef.bottom)
                }
                .clickable(indication = null, interactionSource = interactionSource) {},
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun SessionsDescriptionComponent(sessionDescription: String) {
    Text(
        text = sessionDescription,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun TimeAndVenueComponent(session: SessionPresentationModel) {
    Row() {
        Text(
            text = "${session.sessionStartTime} - ${session.sessionEndTime}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "|",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = session.sessionVenue.uppercase(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun SessionPresenterComponents(sessionSpeakerImageUrl: String, sessionSpeakerName: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = sessionSpeakerImageUrl,
            contentDescription = "session speaker image",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = sessionSpeakerName,
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary)
        )
    }
}