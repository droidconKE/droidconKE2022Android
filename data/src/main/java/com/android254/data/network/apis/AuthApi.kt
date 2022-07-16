package com.android254.data.network.apis

import com.android254.data.network.Constants
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class AuthApi @Inject constructor(
    private val client: HttpClient
) {
    suspend fun logout() {
        val status = client.post("${Constants.BASE_URL}/logout")
    }
}