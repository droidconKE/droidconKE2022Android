package com.android254.data.db.util

import com.android254.data.network.models.responses.SponsorsData
import com.android254.domain.models.Sponsors

object SponsorDataToDomainMapper {

    fun SponsorsData.toDomain() = Sponsors(
            title,
            body ,
            topic ,
            url ,
            image ,
            createdAt
        )
}