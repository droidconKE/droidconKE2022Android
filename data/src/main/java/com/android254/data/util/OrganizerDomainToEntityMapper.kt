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
package com.android254.data.util

import com.android254.data.db.model.OrganizerEntity
import com.android254.domain.models.Creator
import com.android254.domain.models.Organizer

object OrganizerDomainToEntityMapper {

    private fun Creator.toEntity() = OrganizerEntity.CreatorEntity(
        id,
        name,
        email,
        createdAt
    )

    private fun OrganizerEntity.CreatorEntity.toDomain() = Creator(
        id,
        name,
        email,
        createdAt
    )

    fun Organizer.toEntity() = OrganizerEntity(
        id ?: 0,
        name,
        email,
        description,
        facebook,
        twitter,
        instagram,
        logo,
        slug,
        status,
        createdAt,
        creater?.toEntity(),
        upcomingEventsCount,
        totalEventsCount
    )

    fun OrganizerEntity.toDomain() = Organizer(
        id,
        name,
        email,
        description,
        facebook,
        twitter,
        instagram,
        logo,
        slug,
        status,
        createdAt,
        creater?.toDomain(),
        upcomingEventsCount,
        totalEventsCount
    )
}