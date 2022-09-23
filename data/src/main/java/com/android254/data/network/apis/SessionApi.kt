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
import com.android254.data.network.models.responses.GenericPaginatedResponse
import com.android254.data.network.models.responses.SessionApiModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class SessionApi @Inject constructor(
    private val client: HttpClient
) {
    suspend fun fetchSessions(perPage: Int = 20): GenericPaginatedResponse<List<SessionApiModel>> {
        return client.get("${Constants.BASE_URL}/events/droidconke2019-444/sessions") {
            url {
                parameters.append("per_page", perPage.toString())
            }
        }.body()
    }

    suspend fun fetchMoreSessions(
        pageNumber: Int,
        perPage: Int = 20
    ): GenericPaginatedResponse<List<SessionApiModel>> {
        return client.get("${Constants.BASE_URL}/events/droidconke2019-444/sessions") {
            url {
                parameters.append("per_page", perPage.toString())
                parameters.append("page", pageNumber.toString())
            }
        }.body()
    }
}