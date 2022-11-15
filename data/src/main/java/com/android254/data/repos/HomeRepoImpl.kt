package com.android254.data.repos

import com.android254.data.network.apis.SessionsApi
import com.android254.data.network.apis.SpeakersApi
import com.android254.data.network.apis.SponsorsApi
import com.android254.data.network.models.responses.SessionDTO
import com.android254.data.network.models.responses.SpeakerDTO
import com.android254.data.network.models.responses.SpeakersPagedResponse
import com.android254.data.network.models.responses.SponsorsPagedResponse
import com.android254.domain.models.DataResult
import com.android254.domain.models.HomeDetailsDomainModel
import com.android254.domain.models.Session
import com.android254.domain.models.SpeakersDomainModel
import com.android254.domain.models.SponsorsDomainModel
import com.android254.domain.repos.HomeRepo
import javax.inject.Inject
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class HomeRepoImpl @Inject constructor(
    private val sponsorsApi: SponsorsApi,
    private val speakerRemoteSource: SpeakersApi,
    private val sessionsRemoteSource: SessionsApi
) : HomeRepo {
    override suspend fun fetchHomeDetails(): HomeDetailsDomainModel {
        return combine(
            flowOf(sponsorsApi.fetchSponsors()),
            flowOf(speakerRemoteSource.fetchSpeakers()),
            flowOf(sessionsRemoteSource.fetchSessions())
        ) { sponsors, speakers, sessions ->
            HomeDetailsDomainModel(
                isCallForSpeakersEnable = false,
                isEventBannerEnable = true,
                speakers = speakers.getSpeakerList(),
                speakersCount = speakers.getSpeakerList().size,
                sessions = sessions.data.sessionsToDomain(),
                sessionsCount = sessions.data.size,
                sponsors = sponsors.getSponsorsList(),
                organizers = listOf()
            )
        }.first()
    }

    private fun DataResult<SpeakersPagedResponse>.getSpeakerList() =
        when (this) {
            is DataResult.Success -> this.data.data.speakersToDomain()
            else -> emptyList()
        }

    private fun DataResult<SponsorsPagedResponse>.getSponsorsList() =
        when (this) {
            is DataResult.Success -> this.data.toDomain()
            else -> emptyList()
        }

    private fun List<SpeakerDTO>.speakersToDomain() =
        map {
            SpeakersDomainModel(
                imageUrl = it.avatar,
                name = it.name,
                tagline = it.tagline,
                bio = it.twitter.orEmpty(),
                twitterHandle = it.twitter.orEmpty()
            )
        }

    private fun List<SessionDTO>.sessionsToDomain() =
        map {
            Session(
                id = 0,
                description = it.description.orEmpty(),
                session_format = it.sessionFormat.orEmpty(),
                session_level = it.sessionLevel.orEmpty(),
                slug = it.slug.orEmpty(),
                title = it.title.orEmpty(),
                sessionImageUrl = it.sessionImage.orEmpty(),
                sessionRoom = it.description.orEmpty(),
                speakerName = it.speakers?.joinToString(separator = "&").orEmpty()
            )
        }

    private fun SponsorsPagedResponse.toDomain() =
        data.map {
            SponsorsDomainModel(
                sponsorName = it.title,
                sponsorLogoUrl = it.image
            )
        }
}