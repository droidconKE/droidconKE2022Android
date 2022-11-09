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
data class SessionApiModel(
    val id: String,
    val backgroundColor: String,
    val borderColor: String,
    val description: String,
    val end_date_time: String,
    val end_time: String,
    val is_bookmarked: Boolean,
    val is_keynote: Boolean,
    val is_serviceSession: Boolean,
    val session_format: String,
    val session_image: String?,
    val session_level: String,
    val slug: String,
    val start_date_time: String,
    val start_time: String,
    val title: String,
    val rooms: List<SessionRoomApiModel>,
    val speakers: List<SpeakerApiModel>
)