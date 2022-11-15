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