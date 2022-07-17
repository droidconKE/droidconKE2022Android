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
package com.android254.data.dao.network

import com.android254.data.network.apis.AuthApi
import com.android254.data.network.models.payloads.GoogleToken
import com.android254.data.network.models.responses.AccessToken
import com.android254.data.network.models.responses.Status
import com.android254.data.network.models.responses.UserDetails
import com.android254.data.network.util.HttpClientFactory
import com.android254.data.network.util.ServerError
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class AuthApiTest {

    @Test(expected = ServerError::class)
    fun `test ServerError is thrown when a server exception occurs`() {
        val mockEngine = MockEngine {
            delay(500)
            respondError(HttpStatusCode.InternalServerError)
        }
        val httpClient = HttpClientFactory.create(mockEngine)
        val api = AuthApi(httpClient)
        runBlocking {
            val response = api.logout()
        }
    }

    @Test
    fun `test successful logout`() {
        val mockEngine = MockEngine {
            respond(
                content = """{"message": "Success"}""",
                status = HttpStatusCode.OK,
                headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val httpClient = HttpClientFactory.create(mockEngine)
        val api = AuthApi(httpClient)
        runBlocking {
            val response = api.logout()
            assertThat(response, `is`(Status("Success")))
        }
    }

    @Test
    fun `test successful google login`() {
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
        val httpClient = HttpClientFactory.create(mockEngine)
        val api = AuthApi(httpClient)
        runBlocking {
            val accessToken = AccessToken(
                token = "test",
                user = UserDetails(
                    name = "Magak Emmanuel",
                    email = "emashmagak@gmail.com",
                    gender = null,
                    avatar = "http://localhost:8000/upload/avatar/img-20181016-wa0026jpg.jpg"
                )
            )
            val response = api.googleLogin(GoogleToken("some token"))
            assertThat(response, `is`(accessToken))
        }
    }
}