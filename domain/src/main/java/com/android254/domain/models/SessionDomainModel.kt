package com.android254.domain.models

data class SessionDomainModel(
    val backgroundColor: String,
    val borderColor: String,
    val end_date_time: String,
    val end_time: String,
    val is_bookmarked: Boolean,
    val is_keynote: Boolean,
    val is_serviceSession: Boolean,
    val session_image: String?,
    val start_date_time: String,
    val start_time: String,
    val rooms: String,
    val speakers: String,
    val remote_id: String,
    val description: String,
    val session_format: String,
    val session_level: String,
    val slug: String,
    val title: String,
)