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

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.core.app.ApplicationProvider
import com.android254.data.network.apis.SponsorsApi
import com.android254.data.network.models.responses.SponsorsPagedResponse
import com.android254.data.network.util.HttpClientFactory
import com.android254.data.preferences.DefaultTokenProvider
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SponsorsEntityApiTest {

    private lateinit var testDataStore: DataStore<Preferences>

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        testDataStore = PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile("test") }
        )
    }

    @Test
    fun `api should return object on valid json`() {
        val validContent = """
                {
                  "data": [
                    {
                      "title": "Test",
                      "body": "Good one",
                      "topic": "droidconweb",
                      "url": "https://droidcon.co.ke",
                      "image": "http://localhost:8000/upload/event/feeds/dangyntvmaet8jgjpg.jpg",
                      "created_at": "2020-03-19 18:45:49"
                    },
                    {
                      "title": "niko fine",
                      "body": "this is a test",
                      "topic": "droidconweb",
                      "url": "https://droidcon.co.ke",
                      "image": null,
                      "created_at": "2020-03-19 18:43:38"
                    }
                  ],
                  "meta": {
                    "paginator": {
                      "count": 2,
                      "per_page": "10",
                      "current_page": 1,
                      "next_page": null,
                      "has_more_pages": false,
                      "next_page_url": null,
                      "previous_page_url": null
                    }
                  }
                }""".trimIndent()
        val mockEngine = MockEngine {
            respond(
                content = validContent,
                status = HttpStatusCode.OK,
                headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val httpClient = HttpClientFactory(DefaultTokenProvider(testDataStore)).create(mockEngine)
        val api = SponsorsApi(httpClient)
        runBlocking {
            val data = Json.decodeFromString<SponsorsPagedResponse>(validContent)
            val response = api.fetchSponsors(1, 1)
            assertEquals(data, response)
        }
    }

    @Test
    fun `api should throw exception on invalid json`() {
        val invalidContent = """
            {
                  "data": [
                    {
                      "title": "Test",
                      "body": "Good one",
                      "topic": "droidconweb",
                      "url": "https://droidcon.co.ke",
                      "image": "http://localhost:8000/upload/event/feeds/dangyntvmaet8jgjpg.jpg",
                      "created_at": "2020-03-19 18:45:49"
                    },
                    {
                      "title": "niko fine",
                      "body": "this is a test",
                      "topic": "droidconweb",
                      "url": "https://droidcon.co.ke",
                     
                      "created_at": "2020-03-19 18:43:38"
                    }
                  ],
                  "meta": {
                    "paginator": {
                      "count": 2,
                      "per_page": "10",
                      "current_page": 1,
                      "next_page": null,
                      "has_more_pages": false,
                      "next_page_url": null,
                      "previous_page_url": null
                    }
                  }
                }
        """.trimIndent()
        val mockEngine = MockEngine {
            respond(
                content = invalidContent,
                status = HttpStatusCode.OK,
                headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val httpClient = HttpClientFactory(DefaultTokenProvider(testDataStore)).create(mockEngine)
        val api = SponsorsApi(httpClient)

        assertThrows(Exception::class.java) {
            runBlocking {
                api.fetchSponsors(1, 1)
            }
        }
    }
}