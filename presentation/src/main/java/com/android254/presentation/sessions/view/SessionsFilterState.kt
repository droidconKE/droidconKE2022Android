package com.android254.presentation.sessions.view

import java.time.LocalDate

data class SessionsFilterState(
    val levels: List<String> = listOf(),
    val topics: List<String> = listOf(),
    val rooms: List<String> = listOf(),
    val sessionTypes: List<String> = listOf()
)