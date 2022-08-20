package com.android254.data.network.apis

import com.android254.data.network.Constants
import com.android254.data.network.models.responses.Speaker
import com.android254.data.network.util.safeApiCall
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class SpeakerApi @Inject constructor(
    private val client: HttpClient
) {
    suspend fun fetchSpeakers(): List<Speaker> = safeApiCall {
        return@safeApiCall client.get("${Constants.BASE_URL}/speakers").body()
    }
}