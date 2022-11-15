package com.android254.presentation.models

import com.android254.presentation.sessions.utils.SessionsFilterCategory

data class SessionsFilterOption(
    val label: String,
    val value: String,
    val type: SessionsFilterCategory
)