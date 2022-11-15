package com.android254.data.network.models.responses


data class Organizer(
    val id: Int?,
    val name: String?,
    val email: String?,
    val description: String?,
    val facebook: String?,
    val twitter: String?,
    val instagram: String?,
    val logo: String?,
    val slug: String?,
    val status: String?,
    val createdAt: String?,
    val creator: Creator?,
    val upcomingEventsCount: Int?,
    val totalEventsCount: Int?
)
