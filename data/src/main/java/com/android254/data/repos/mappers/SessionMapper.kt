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
package com.android254.data.repos.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.android254.data.db.model.SessionEntity
import com.android254.data.network.models.responses.SessionApiModel
import com.android254.domain.models.Session
import com.google.gson.Gson
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun SessionEntity.toDomainModel() = Session(
    id = this.id.toString(),
    description = this.description,
    title = this.title,
    session_format = this.session_format,
    session_level = this.session_level,
    slug = this.slug,
    end_date_time = this.end_date_time,
    is_bookmarked = this.is_bookmarked,
    end_time = this.end_time,
    is_keynote = this.is_keynote,
    is_serviceSession = this.is_serviceSession,
    session_image = this.session_image,
    start_date_time = this.start_date_time,
    start_time = this.start_time,
    rooms = this.rooms,
    speakers = this.speakers,
    remote_id = this.remote_id
)

@RequiresApi(Build.VERSION_CODES.O)
fun SessionApiModel.toEntity(): SessionEntity {
    val gson = Gson()
    return SessionEntity(
        id = 0,
        description = description,
        title = title,
        session_format = session_format,
        session_level = session_level,
        slug = slug,
        end_date_time = this.end_date_time,
        is_bookmarked = this.is_bookmarked,
        end_time = this.end_time,
        is_keynote = this.is_keynote,
        is_serviceSession = this.is_serviceSession,
        session_image = this.session_image,
        start_date_time = this.start_date_time,
        start_time = this.start_time,
        rooms = this.rooms.joinToString(separator = ",") { it.title },
        speakers = gson.toJson(this.speakers),
        start_timestamp = fromString(this.start_date_time),
        remote_id = this.id,
        sessionImageUrl = this.session_image.toString(),
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun fromString(offsetDateTime: String): Long {
    val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return LocalDateTime.parse(offsetDateTime, pattern).toInstant(ZoneOffset.ofHours(3))
        .toEpochMilli()
}
