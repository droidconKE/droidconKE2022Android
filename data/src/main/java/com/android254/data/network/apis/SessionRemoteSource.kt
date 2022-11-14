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

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.android254.data.network.models.responses.BookmarkResponse
import com.android254.data.network.models.responses.EventScheduleResponse
import com.android254.data.network.models.responses.SessionApiModel
import com.android254.data.network.util.TokenProvider
import com.android254.data.preferences.DefaultTokenProvider
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class SessionRemoteSource @Inject constructor(
    private val client: HttpClient,
    private val tokenProvider: DefaultTokenProvider,
    private val dataStore: DataStore<Preferences>
) {
    suspend fun fetchSessions(): EventScheduleResponse<Map<String, List<SessionApiModel>>> {
        return client.get("https://droidcon-erp.herokuapp.com/api/v1/events/droidconke-2022-281/schedule") {
            header("Api-Authorization-Key", "droidconKe-2020")
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