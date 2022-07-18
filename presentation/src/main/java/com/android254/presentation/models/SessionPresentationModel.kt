package com.android254.presentation.models

data class SessionPresentationModel(
    val id: String,
    val sessionTitle: String,
    val sessionDescription: String,
    val sessionVenue: String,
    val sessionSpeakerImage: String,
    val sessionSpeakerName: String,
    val sessionTime: String
)
