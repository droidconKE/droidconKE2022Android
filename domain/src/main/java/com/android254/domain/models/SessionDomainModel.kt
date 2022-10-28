package com.android254.domain.models

data class SessionDomainModel(
    val id: Int,
    val description: String,
    val session_format: String,
    val session_level: String,
    val slug: String,
//    TODO create converter val speakers: List<SpeakerApiModel>,
    val title: String
)