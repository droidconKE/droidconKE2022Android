package com.android254.presentation.sessions.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android254.presentation.common.components.SessionPresentationModel
import com.android254.presentation.common.components.SessionsCard
import com.android254.presentation.common.theme.DroidconKE2022Theme

val Session = SessionPresentationModel(
    id = "",
    sessionTitle = "Android 254",
    sessionDescription = "The community and the efforts",
    sessionVenue = "9:30AM - 10:15AM | ROOM 1",
    sessionSpeakerImage = "",
    sessionTime = "9:30AM",
    sessionSpeakerName = "Kagiri Charles"
)

@Composable
fun SessionsScreen() {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        (0..10).forEach { _ ->
            item {
                SessionsCard(
                    sessionPresentationModel = Session
                ) {
                    Toast.makeText(context, "This session is still open", Toast.LENGTH_LONG).show()
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