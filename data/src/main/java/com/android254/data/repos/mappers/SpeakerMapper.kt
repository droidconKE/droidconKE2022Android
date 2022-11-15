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

import com.android254.data.db.model.SpeakerEntity
import com.android254.data.network.models.responses.SpeakerDTO
import com.android254.domain.models.Speaker

fun SpeakerDTO.toEntity() = SpeakerEntity(
    id = 0,
    name = name,
    tagline = tagline,
    bio = bio,
    avatar = avatar,
    twitter = twitter ?: ""
)

fun SpeakerEntity.toDomainModel() = Speaker(
    id = id,
    imageUrl = avatar,
    name = name,
    bio = bio,
    tagline = tagline,
    twitterHandle = twitter
)

fun SpeakerDTO.toDomain() = Speaker(
    imageUrl = avatar,
    name = name,
    tagline = tagline,
    bio = bio,
    twitterHandle = twitter.orEmpty()
)