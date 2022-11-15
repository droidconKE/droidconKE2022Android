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
package com.android254.data.repos

import android.os.Build
import androidx.annotation.RequiresApi
import com.android254.data.network.apis.SessionsApi
import com.android254.data.network.apis.SpeakersApi
import com.android254.data.network.apis.SponsorsApi
import com.android254.data.network.models.responses.SpeakersPagedResponse
import com.android254.data.network.models.responses.SponsorsPagedResponse
import com.android254.data.repos.mappers.toDomain
import com.android254.data.repos.mappers.toDomainModel
import com.android254.data.repos.mappers.toEntity
import com.android254.domain.models.DataResult
import com.android254.domain.models.HomeDetails
import com.android254.domain.repos.HomeRepo
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(
    private val sponsorsApi: SponsorsApi,
    private val speakersApi: SpeakersApi,
    private val sessionsApi: SessionsApi
) : HomeRepo {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun fetchHomeDetails(): HomeDetails {
        return combine(
            flowOf(sponsorsApi.fetchSponsors()),
            flowOf(speakersApi.fetchSpeakers()),
            flowOf(sessionsApi.fetchSessions())
        ) { sponsors, speakers, sessions ->
            HomeDetails(
                isCallForSpeakersEnable = false,
                isEventBannerEnable = true,
                speakers = speakers.getSpeakerList(),
                speakersCount = speakers.getSpeakerList().size,
                sessions = sessions.data.flatMap { (_, value) -> value }.map {
                    it.toEntity()
                }.map { it.toDomainModel() },
                sessionsCount = sessions.data.size,
                sponsors = sponsors.getSponsorsList(),
                organizers = listOf()
            )
        }.first()
    }

    private fun DataResult<SpeakersPagedResponse>.getSpeakerList() =
        when (this) {
            is DataResult.Success -> this.data.data.map { it.toDomain() }
            else -> emptyList()
        }

    private fun DataResult<SponsorsPagedResponse>.getSponsorsList() =
        when (this) {
            is DataResult.Success -> this.data.data.map { it.toDomain() }
            else -> emptyList()
        }
}