package com.android254.data.repos

import com.android254.data.network.apis.SessionsApi
import com.android254.data.network.apis.SpeakersApi
import com.android254.data.network.apis.SponsorsApi
import com.android254.data.network.models.responses.SpeakersPagedResponse
import com.android254.data.network.models.responses.SponsorsPagedResponse
import com.android254.data.repos.mappers.toDomain
import com.android254.domain.models.DataResult
import com.android254.domain.models.HomeDetailsDomainModel
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
    override suspend fun fetchHomeDetails(): HomeDetailsDomainModel {
        return combine(
            flowOf(sponsorsApi.fetchSponsors()),
            flowOf(speakersApi.fetchSpeakers()),
            flowOf(sessionsApi.fetchSessions())
        ) { sponsors, speakers, sessions ->
            HomeDetailsDomainModel(
                isCallForSpeakersEnable = false,
                isEventBannerEnable = true,
                speakers = speakers.getSpeakerList(),
                speakersCount = speakers.getSpeakerList().size,
                sessions = sessions.data.map { it.toDomain() },
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