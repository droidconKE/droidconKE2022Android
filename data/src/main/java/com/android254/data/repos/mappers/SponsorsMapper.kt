package com.android254.data.repos.mappers

import com.android254.data.network.models.responses.SponsorDTO
import com.android254.domain.models.Sponsors

fun SponsorDTO.toDomain() = Sponsors(
    sponsorName = title,
    sponsorLogoUrl = image
)