package com.android254.data.network

import com.android254.data.network.apis.AuthApi
import com.android254.data.network.apis.SessionApi
import com.android254.data.network.models.responses.GenericPaginatedResponse
import com.android254.data.network.models.responses.PaginationMetaData
import com.android254.data.network.models.responses.ResponseMetaData
import com.android254.data.network.models.responses.SessionApiModel
import com.android254.data.network.util.HttpClientFactory
import com.android254.data.network.util.ServerError
import com.android254.data.preferences.DefaultTokenProvider
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is`

class SessionApiTest {
    @Test
    fun `sessions are fetched successfully`() {
        val expectedResponse: GenericPaginatedResponse<List<SessionApiModel>> =
            GenericPaginatedResponse(
                data = listOf(),
                meta = ResponseMetaData(
                    paginator = PaginationMetaData(
                        count = 1,
                        current_page = 1,
                        has_more_pages = true,
                        next_page = "",
                        next_page_url = "",
                        per_page = "",
                        previous_page_url = ""
                    )
                )
            )


        val mockHttpEngine = MockEngine {
            if (it.method == HttpMethod.Get && it.url.toString() == "https://api.droidcon.test/v1/events/droidconke2019-444/sessions?per_page=20") {
                respond(
                    content = Json.encodeToString(expectedResponse),
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            } else {
                respondError(HttpStatusCode.NotFound)
            }
        }

        val httpClient = HttpClientFactory(MockTokenProvider()).create(mockHttpEngine)

        runBlocking {
            // WHEN
            val response = SessionApi(httpClient).fetchSessions()
            // THEN
            assertThat(response, `is`(expectedResponse))
        }
    }
}