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

import com.android254.data.db.model.Session
import com.android254.data.network.models.responses.SessionApiModel
import com.android254.domain.models.SessionDomainModel

fun Session.toDomainModel() = SessionDomainModel(
    id = this.id,
    description = this.description,
    title = this.title,
    session_format = this.session_format,
    session_level = this.session_level,
    slug = this.slug,
    backgroundColor = this.backgroundColor,
    borderColor = this.borderColor,
    end_date_time = this.end_date_time,
    is_bookmarked = this.is_bookmarked,
    end_time = this.end_time,
    is_keynote = this.is_keynote,
    is_serviceSession = this.is_serviceSession,
    session_image = this.session_image,
    start_date_time = this.start_date_time,
    start_time = this.start_time
)

fun SessionApiModel.toEntity() = Session(
    id = 0,
    description = description,
    title = title,
    session_format = session_format,
    session_level = session_level,
    slug = slug,
    backgroundColor = this.backgroundColor,
    borderColor = this.borderColor,
    end_date_time = this.end_date_time,
    is_bookmarked = this.is_bookmarked,
    end_time = this.end_time,
    is_keynote = this.is_keynote,
    is_serviceSession = this.is_serviceSession,
    session_image = this.session_image,
    start_date_time = this.start_date_time,
    start_time = this.start_time
)