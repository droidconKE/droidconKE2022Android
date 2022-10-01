package com.android254.data.repos

import com.android254.data.network.apis.SessionApi
import com.android254.data.network.models.responses.PaginatedResponse
import com.android254.data.network.models.responses.SessionApiModel
import com.android254.domain.repos.SessionsRepo
import javax.inject.Inject

class SessionsManager @Inject constructor(
    private val api: SessionApi
) : SessionsRepo {
    override suspend fun fetchAndSaveSessions() {
        try {
            val response = api.fetchSessions()
        } catch (e: Exception) {

        }
    }
}