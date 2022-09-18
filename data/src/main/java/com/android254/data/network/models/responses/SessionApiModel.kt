package com.android254.data.network.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class SessionApiModel(
    val description: String,
    val session_format: String,
    val session_level: String,
    val slug: String,
    val speakers: List<SpeakerApiModel>,
    val title: String
)