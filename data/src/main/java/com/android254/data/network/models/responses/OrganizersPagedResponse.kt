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
package com.android254.data.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrganizersPagedResponse(
    @SerialName("data") var data: List<Organizer>,
    @SerialName("meta") var meta: Meta?
)

@Serializable
data class Organizer(
    @SerialName("id") var id: Int?,
    @SerialName("name") var name: String?,
    @SerialName("email") var email: String?,
    @SerialName("description") var description: String?,
    @SerialName("facebook") var facebook: String?,
    @SerialName("twitter") var twitter: String?,
    @SerialName("instagram") var instagram: String?,
    @SerialName("logo") var logo: String?,
    @SerialName("slug") var slug: String?,
    @SerialName("status") var status: String?,
    @SerialName("created_at") var createdAt: String?,
    @SerialName("creater") var creater: Creator?,
    @SerialName("upcoming_events_count") var upcomingEventsCount: Int?,
    @SerialName("total_events_count") var totalEventsCount: Int?
)

@Serializable
data class Creator(
    @SerialName("id") var id: Int?,
    @SerialName("name") var name: String?,
    @SerialName("email") var email: String?,
    @SerialName("created_at") var createdAt: String?
)

@Serializable
data class Paginator(
    @SerialName("count") var count: Int? = null,
    @SerialName("per_page") var perPage: String? = null,
    @SerialName("current_page") var currentPage: Int? = null,
    @SerialName("next_page") var nextPage: String? = null,
    @SerialName("has_more_pages") var hasMorePages: Boolean? = null,
    @SerialName("next_page_url") var nextPageUrl: String? = null,
    @SerialName("previous_page_url") var previousPageUrl: String? = null
)

@Serializable
data class Meta(
    @SerialName("paginator") var paginator: Paginator?
)