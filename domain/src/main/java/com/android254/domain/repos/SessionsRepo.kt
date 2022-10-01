package com.android254.domain.repos

interface SessionsRepo {
    suspend fun fetchAndSaveSessions()
}