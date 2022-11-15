package com.android254.domain.models

data class HomeDetailsDomainModel(
    val isCallForSpeakersEnable: Boolean,
    val isEventBannerEnable: Boolean,
    val sessions: List<Session>,
    val sessionsCount: Int,
    val speakers: List<SpeakersDomainModel>,
    val speakersCount: Int,
    val sponsors: List<SponsorsDomainModel>,
    val organizers: List<OrganizingPartnersDomainModel>
)