package com.android254.data.db.model

import com.android254.data.network.util.EntityMapper
import com.android254.domain.models.Sponsors

class SponsorMapper:EntityMapper<SponsorsEntity,Sponsors> {
    override fun mapFromEntity(entity: SponsorsEntity): Sponsors {
        return Sponsors(
            title = entity.title,
            body = entity.body,
            topic = entity.topic,
            url = entity.url,
            image = entity.image,
            createdAt = entity.createdAt

        )
    }

    override fun mapToEntity(domain: Sponsors): SponsorsEntity {
        return SponsorsEntity(
            title = domain.title,
            body = domain.body,
            topic = domain.topic,
            url = domain.url,
            image = domain.image,
            createdAt = domain.createdAt

        )
    }
}