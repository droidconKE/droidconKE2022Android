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

import kotlinx.serialization.Serializable

@Serializable
data class PaginationMetaData(
    val count: Int,
    val current_page: Int,
    val has_more_pages: Boolean,
    val next_page: String?,
    val next_page_url: String?,
    val per_page: String,
    val previous_page_url: String?
)