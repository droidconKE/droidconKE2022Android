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