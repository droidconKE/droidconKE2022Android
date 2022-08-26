/*
 * Copyright 2022 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.data.network

import com.android254.data.network.apis.SpeakerRemoteSource
import com.android254.data.network.models.responses.SpeakerApiModel
import com.android254.data.network.util.HttpClientFactory
import com.android254.data.network.util.ServerError
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SpeakerRemoteSourceTest {
    @Test(expected = ServerError::class)
    fun `test ServerError is thrown when http client returns server error response`() {
        val mockHttpEngine = MockEngine {
            respondError(HttpStatusCode.InternalServerError)
        }
        val httpClient = HttpClientFactory(MockTokenProvider())
            .create(mockHttpEngine)

        runBlocking {
            SpeakerRemoteSource(httpClient).fetchSpeakers()
        }
    }

    @Test(expected = ResponseException::class)
    fun `test ResponseException is thrown when http client returns error response beside server error`() {
        val mockHttpEngine = MockEngine {
            respondError(HttpStatusCode.NotFound)
        }
        val httpClient = HttpClientFactory(MockTokenProvider())
            .create(mockHttpEngine)

        runBlocking {
            SpeakerRemoteSource(httpClient).fetchSpeakers()
        }
    }

    @Test
    fun `test successful speakers fetch`() {
        // GIVEN
        val expectedResponse = listOf(
            SpeakerApiModel(
                id = "1",
                name = "John Doe",
                shortBio = "Cool guy",
                bio = "Very cool guy",
                avatar = "https://example.com",
                twitter = null
            ),
        )
        val mockHttpEngine = MockEngine {
            // To ensure correct http method and url are used
            if (it.method == HttpMethod.Get &&
                it.url.toString() == "${Constants.BASE_URL}/speakers"
            ) {
                respond(
                    content = Json.encodeToString(expectedResponse),
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            } else {
                respondError(HttpStatusCode.NotFound)
            }
        }
        val httpClient = HttpClientFactory(MockTokenProvider())
            .create(mockHttpEngine)

        runBlocking {
            // WHEN
            val response = SpeakerRemoteSource(httpClient).fetchSpeakers()

            // THEN
            assertThat(response, `is`(expectedResponse))
        }
    }
}