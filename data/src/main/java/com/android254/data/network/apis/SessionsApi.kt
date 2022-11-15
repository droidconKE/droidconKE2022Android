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
package com.android254.data.network.apis

import com.android254.data.network.Constants
import com.android254.data.network.models.responses.BookmarkResponse
import com.android254.data.network.models.responses.EventScheduleResponse
import com.android254.data.network.models.responses.SessionApiModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class SessionsApi @Inject constructor(
    private val client: HttpClient,
) {
    suspend fun fetchSessions(): EventScheduleResponse<Map<String, List<SessionApiModel>>> {
        return client.get("${Constants.BASE_URL}/events/${Constants.EVENT_SLUG}/schedule") {
            header("Api-Authorization-Key", Constants.API_KEY)
            url {
                parameters.append("grouped", "true")
            }
        }.body()
    }

    suspend fun updateBookmarkedStatus(string: String): BookmarkResponse {
        return client.post("https://droidcon-erp.herokuapp.com/api/v1/events/droidconke-2022-281/bookmark_schedule/$string") {
            header("Api-Authorization-Key", "droidconKe-2020")
            header("Authorization", "Bearer token")
        }.body()
    }
}