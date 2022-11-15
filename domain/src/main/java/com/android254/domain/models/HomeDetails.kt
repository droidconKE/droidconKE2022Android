package com.android254.domain.models

data class HomeDetails(
    val isCallForSpeakersEnable: Boolean,
    val isEventBannerEnable: Boolean,
    val sessions: List<Session>,
    val sessionsCount: Int,
    val speakers: List<Speaker>,
    val speakersCount: Int,
    val sponsors: List<Sponsors>,
    val organizers: List<OrganizingPartners>
)