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

import com.android254.data.network.apis.SessionRemoteSource
import com.android254.data.network.models.responses.PaginatedResponse
import com.android254.data.network.models.responses.PaginationMetaData
import com.android254.data.network.models.responses.ResponseMetaData
import com.android254.data.network.models.responses.SessionApiModel
import com.android254.data.network.util.HttpClientFactory
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is`

class SessionApiTest {
    @Test
    fun `sessions are fetched successfully`() {
        val expectedResponse: PaginatedResponse<List<SessionApiModel>> =
            PaginatedResponse(
                data = listOf(),
                meta = ResponseMetaData(
                    paginator = PaginationMetaData(
                        count = 0,
                        current_page = 1,
                        has_more_pages = false,
                        next_page = null,
                        next_page_url = null,
                        per_page = "20",
                        previous_page_url = null
                    )
                )
            )

        val responseText = """
            {
               data: [],
               meta: {
                 "paginator": {
                      "count": 0,
                      "per_page": "20",
                      "current_page": 1,
                      "next_page": null,
                      "has_more_pages": false,
                      "next_page_url": null,
                      "previous_page_url": null
                    }
               }
            }
        """.trimIndent()
        val mockHttpEngine = MockEngine {
            respond(
                content = responseText,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        val httpClient = HttpClientFactory(MockTokenProvider()).create(mockHttpEngine)

        runBlocking {
            // WHEN
            val response = SessionRemoteSource(httpClient).fetchSessions()
            // THEN
            assertThat(response, `is`(expectedResponse))
        }
    }
}