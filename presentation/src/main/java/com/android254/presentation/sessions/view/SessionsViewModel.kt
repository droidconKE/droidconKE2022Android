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

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android254.presentation.models.SessionPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SessionsViewModel @Inject constructor() : ViewModel() {
    var sessions = mutableStateOf(sessionsList)
}
val sessionsList = listOf(
    SessionPresentationModel(
        id = "545",
        sessionTitle = "Transforming farmers lives using Android in Kenya",
        sessionDescription = "",
        sessionVenue = "Room 1",
        sessionSpeakerName = "Harun Wangereka",
        sessionStartTime = "10.00 am",
        sessionEndTime = "",
        amOrPm = "",
        isStarred = false,
        sessionSpeakerImage = "https://firebasestorage.googleapis.com/v0/b/mobifishtest.appspot.com/o/FWMmgzPWAAMh9rp.png?alt=media&token=6378094c-a4b8-45cb-a23e-a6cd4280560a",
    ),
    SessionPresentationModel(
        id = "545",
        sessionTitle = "Compose Beyond Material Design",
        sessionDescription = "",
        sessionVenue = "Room 1",
        sessionSpeakerName = "Harun Wangereka",
        sessionStartTime = "10.00 am",
        sessionEndTime = "",
        amOrPm = "",
        isStarred = false,
        sessionSpeakerImage = "https://firebasestorage.googleapis.com/v0/b/mobifishtest.appspot.com/o/FVIona4WIAEWR93.png?alt=media&token=ddc69aaf-fa81-48a8-a8e5-008cebfe161f",
    ),
)