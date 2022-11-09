package com.android254.presentation.sessions.view

import java.time.LocalDate

data class SessionsFilterState(
    var date: LocalDate? = null,
    val level: List<String> = listOf(),
    val topic: List<String> = listOf(),
    val room: List<String> = listOf(),
    val sessionType: List<String> = listOf()
)