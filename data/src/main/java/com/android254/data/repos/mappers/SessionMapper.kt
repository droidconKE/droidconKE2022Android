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

import com.android254.data.db.model.SessionEntity
import com.android254.data.network.models.responses.SessionDTO
import com.android254.domain.models.Session

fun SessionEntity.toDomainModel() = Session(
    id = this.id,
    description = this.description,
    title = this.title,
    session_format = this.session_format,
    session_level = this.session_level,
    slug = this.slug,
    sessionImageUrl = sessionImageUrl,
    sessionRoom = sessionRoom,
    speakerName = speakerName
)

fun SessionDTO.toEntity() = SessionEntity(
    id = 0,
    description = description.orEmpty(),
    title = title.orEmpty(),
    session_format = sessionFormat.orEmpty(),
    session_level = sessionLevel.orEmpty(),
    slug = slug.orEmpty(),
    sessionRoom = "",
    sessionImageUrl = sessionImage.orEmpty(),
    speakerName = speakers?.joinToString(" & ").orEmpty()
)

fun SessionDTO.toDomain() = Session(
    id = 0,
    description = description.orEmpty(),
    session_format = sessionFormat.orEmpty(),
    session_level = sessionLevel.orEmpty(),
    slug = slug.orEmpty(),
    title = title.orEmpty(),
    sessionImageUrl = sessionImage.orEmpty(),
    sessionRoom = description.orEmpty(),
    speakerName = speakers?.joinToString(separator = "&").orEmpty()
)