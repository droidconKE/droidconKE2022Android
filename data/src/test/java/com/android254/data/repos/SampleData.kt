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
package com.android254.data.repos

import com.android254.data.network.models.responses.*
import com.android254.data.network.models.responses.FeedDTO
import com.android254.data.network.models.responses.PaginatedResponse
import com.android254.data.network.models.responses.PaginationMetaData
import com.android254.data.network.models.responses.ResponseMetaData
import com.android254.data.network.models.responses.SessionDTO
import java.time.LocalDateTime

val results = EventScheduleResponse(
    data = mapOf(
        "2022-11-16" to listOf(
            SessionApiModel(
                id = "String",
                backgroundColor = "String",
                borderColor = "String",
                description = "String",
                end_date_time = "String",
                end_time = "String",
                is_bookmarked = false,
                is_keynote = false,
                is_serviceSession = false,
                session_format = "String",
                session_image = "String",
                session_level = "String",
                slug = "String",
                start_date_time = "String",
                start_time = "String",
                title = "String",
                rooms = listOf(),
                speakers = listOf()
            )
        )
    )
)

val feed = listOf(
    FeedDTO(
        "Feed",
        "Feed feed feed",
        "feed",
        "",
        "",
        LocalDateTime.now()
    )
)