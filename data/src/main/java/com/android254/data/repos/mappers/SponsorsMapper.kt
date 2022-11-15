package com.android254.data.repos.mappers

import com.android254.data.network.models.responses.SponsorDTO
import com.android254.domain.models.SponsorsDomainModel

fun SponsorDTO.toDomain() = SponsorsDomainModel(
    sponsorName = title,
    sponsorLogoUrl = image
)