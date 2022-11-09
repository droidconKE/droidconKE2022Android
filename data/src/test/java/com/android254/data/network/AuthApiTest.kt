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
import com.android254.data.network.apis.AuthApi
import com.android254.data.network.models.payloads.GoogleToken
import com.android254.data.network.models.responses.AccessToken
import com.android254.data.network.models.responses.Status
import com.android254.data.network.models.responses.UserDetails
import com.android254.data.network.util.HttpClientFactory
import com.android254.data.network.util.ServerError
import com.android254.data.preferences.DefaultTokenProvider
import com.google.common.truth.Truth
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AuthApiTest {

    private lateinit var testDataStore: DataStore<Preferences>

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        testDataStore = PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile("test") }
        )
    }

    @Test(expected = ServerError::class)
    fun `test ServerError is thrown when a server exception occurs`() {
        // Given
        val mockEngine = MockEngine {
            delay(500)
            respondError(HttpStatusCode.InternalServerError)
        }
        val httpClient = HttpClientFactory(DefaultTokenProvider(testDataStore)).create(mockEngine)
        val api = AuthApi(httpClient)

        // When
        runTest { api.logout() }
    }

    @Test
    fun `test successful logout`() {
        // Given
        val mockEngine = MockEngine {
            respond(
                content = """{"message": "Success"}""",
                status = HttpStatusCode.OK,
                headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val httpClient = HttpClientFactory(DefaultTokenProvider(testDataStore)).create(mockEngine)
        val api = AuthApi(httpClient)

        // Then
        runTest {
            api.logout().also {
                Truth.assertThat(it).isEqualTo(Status("Success"))
            }
        }
    }

    @Test
    fun `test successful google login`() {
        // Given
        val content = """
            {
              "token": "test",
              "user": {
                "name": "Magak Emmanuel",
                "email": "emashmagak@gmail.com",
                "gender": null,
                "avatar": "http://localhost:8000/upload/avatar/img-20181016-wa0026jpg.jpg",
                "created_at": "2020-03-18 17:50:28"
              }
            }
        """.trimIndent()
        val mockEngine = MockEngine {
            respond(
                content = content,
                status = HttpStatusCode.OK,
                headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val httpClient = HttpClientFactory(DefaultTokenProvider(testDataStore)).create(mockEngine)
        val api = AuthApi(httpClient)

        val accessToken = AccessToken(
            token = "test",
            user = UserDetails(
                name = "Magak Emmanuel",
                email = "emashmagak@gmail.com",
                gender = null,
                avatar = "http://localhost:8000/upload/avatar/img-20181016-wa0026jpg.jpg"
            )
        )

        // Then
        runTest {
            api.googleLogin(GoogleToken("some token")).also {
                Truth.assertThat(it).isEqualTo(accessToken)
            }
        }

    }
}