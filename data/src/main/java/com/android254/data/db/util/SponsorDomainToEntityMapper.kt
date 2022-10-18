package com.android254.data.db.util

import com.android254.data.db.model.SponsorsEntity
import com.android254.domain.models.Sponsors

object SponsorDomainToEntityMapper {
    fun Sponsors.toEntity() = SponsorsEntity(
       title,
       body,
       topic,
       url,
       image,
       createdAt
    )

    fun SponsorsEntity.toDomain() = Sponsors(
        title,
        body ,
        topic ,
        url ,
        image ,
        createdAt
    )
}