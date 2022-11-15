package com.android254.data.network.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class SpeakerApiModel(
    val avatar: String?,
    val biography: String?,
    val blog: String?,
    val company_website: String?,
    val facebook: String?,
    val instagram: String?,
    val linkedin: String?,
    val name: String,
    val tagline: String?,
    val twitter: String?
)