package com.android254.data.network.models.responses

data class SessionApiModel(
    val id: String,
    val backgroundColor: String,
    val borderColor: String,
    val description: String,
    val end_date_time: String,
    val end_time: String,
    val is_bookmarked: Boolean,
    val is_keynote: Boolean,
    val is_serviceSession: Boolean,
    val session_format: String,
    val session_image: String?,
    val session_level: String,
    val slug: String,
    val start_date_time: String,
    val start_time: String,
    val title: String,
    val rooms: List<SessionRoomApiModel>,
    val speakers: List<SpeakerApiModel>
)
