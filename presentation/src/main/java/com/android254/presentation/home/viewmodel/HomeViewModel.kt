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
package com.android254.presentation.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.domain.models.Session
import com.android254.domain.models.SpeakersDomainModel
import com.android254.domain.repos.HomeRepo
import com.android254.presentation.home.viewstate.HomeViewState
import com.android254.presentation.models.SessionPresentationModel
import com.android254.presentation.models.SpeakerUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepo: HomeRepo
) : ViewModel() {

    var viewState by mutableStateOf(HomeViewState())
        private set

    fun onGetHomeScreenDetails() {
        viewModelScope.launch {
            with(homeRepo.fetchHomeDetails()) {
                viewState
                viewState = viewState.copy(
                    isPosterVisible = this.isEventBannerEnable,
                    isCallForSpeakersVisible = this.isCallForSpeakersEnable,
                    linkToCallForSpeakers = "",
                    isSignedIn = false,
                    speakers = speakers.toSpeakersPresentation(),
                    sponsors = sponsors.map { it.sponsorLogoUrl },
                    organizedBy = organizers.map { it.organizerLogoUrl },
                    sessions = sessions.toSessionsPresentation()
                )
            }
        }
    }

    private fun List<SpeakersDomainModel>.toSpeakersPresentation() =
        map {
            SpeakerUI(
                imageUrl = it.imageUrl,
                name = it.name,
                tagline = it.tagline,
                bio = it.bio,
                twitterHandle = it.twitterHandle
            )
        }

    private fun List<Session>.toSessionsPresentation() =
        map {
            SessionPresentationModel(
                id = it.id,
                sessionTitle = it.title,
                sessionDescription = it.description,
                sessionVenue = it.sessionRoom,
                sessionSpeakerImage = it.sessionImageUrl,
                sessionSpeakerName = it.speakerName,
                sessionStartTime = "10:00 AM",
                sessionEndTime = "12:00 PM",
                amOrPm = "AM",
                isStarred = false
            )
        }
}