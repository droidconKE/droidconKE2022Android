package com.android254.presentation.models

data class SessionDetailsPresentationModel(
    val id: String,
    val title: String,
    val description: String,
    val venue: String,
    val speakerImage: String,
    val speakerName: String,
    val startTime: String,
    val endTime: String,
    val amOrPm: String,
    val isStarred: Boolean,
    val format: String,
    val level: String,
    val twitterHandle: String?,
    val sessionImageUrl: String?,
    val timeSlot: String
)