package com.android254.data.network.apis

import com.android254.data.network.Constants
import com.android254.data.network.models.responses.GenericPaginatedResponse
import com.android254.data.network.models.responses.PaginationMetaData
import com.android254.data.network.models.responses.SessionApiModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class SessionApi @Inject constructor(
    private val client: HttpClient
) {
    suspend fun fetchSessions(perPage: Int = 20): GenericPaginatedResponse<List<SessionApiModel>> {
        return client.get("${Constants.BASE_URL}/events/droidconke2019-444/sessions") {
            url {
                parameters.append("per_page", perPage.toString())
            }
        }.body()
    }

    suspend fun fetchMoreSessions(
        pageNumber: Int,
        perPage: Int = 20
    ): GenericPaginatedResponse<List<SessionApiModel>> {
        return client.get("${Constants.BASE_URL}/events/droidconke2019-444/sessions") {
            url {
                parameters.append("per_page", perPage.toString())
                parameters.append("page", pageNumber.toString())
            }
        }.body()
    }
}