package com.android254.data.network.apis

import com.android254.data.network.Constants
import com.android254.data.network.models.responses.SpeakerApiModel
import com.android254.data.network.util.safeApiCall
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class SpeakerRemoteSource @Inject constructor(
    private val client: HttpClient
) {
    suspend fun fetchSpeakers(): List<SpeakerApiModel> = safeApiCall {
        return@safeApiCall client.get("${Constants.BASE_URL}/speakers").body()
    }
}