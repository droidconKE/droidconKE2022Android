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
package com.android254.presentation.sessionDetails

import androidx.lifecycle.ViewModel
import com.android254.presentation.sessionDetails.view.SessionDetailsPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class SessionDetailsViewModel @Inject constructor() : ViewModel() {
    fun getSessionDetailsById(sessionId: String): Flow<SessionDetailsPresentationModel> {
        // TODO: (Rashan) Replace with actual implementation
        return flow {
            delay(100)
            emit(dummySessionDetails)
        }
    }
}

val dummySessionDetails = SessionDetailsPresentationModel(
    speakerName = "Frank Tamre",
    isFavourite = true,
    title = "Compose Beyond Material Design",
    description = "Been in the tech industry for over 20 years. Am passionate about developer communities, motivating people and building successfulBeen in the tech industry for over 20 years. Am passionate about developer communities, motivating people and building successfulBeen in the tech industry for over 20 years. Am passionate about developer communities, motivating people and building successfulBeen in the tech industry for over 20 years. Am passionate about developer communities, motivating people and building successfulBeen in the tech industry for over 20 years. Am passionate about developer communities, motivating people and building successfulBeen in the tech industry for over 20 years. Am passionate about developer communities, motivating people and building successful",
    sessionImageUrl = "https://www.freepnglogos.com/uploads/twitter-logo-png/twitter-logo-vector-png-clipart-1.png",
    timeSlot = "9.30AM - 10:15AM",
    room = "ROOM 1",
    level = "Beginner",
    twitterHandle = "PriestTamzi"
)