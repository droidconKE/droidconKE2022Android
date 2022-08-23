package com.android254.data.network.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class SpeakerApiModel(
    val id: String,
    val name: String,
    val bio: String,
    val shortBio: String,
    val avatar: String,
    val twitter: String?
)