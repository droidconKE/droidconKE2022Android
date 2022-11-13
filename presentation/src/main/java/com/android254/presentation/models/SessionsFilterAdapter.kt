package com.android254.presentation.models

import com.android254.presentation.sessions.utils.SessionsFilterCategory

data class SessionsFilterAdapter(
    val categories: MutableMap<SessionsFilterCategory, List<SessionsFilterOption>>,
)