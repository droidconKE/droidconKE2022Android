package com.android254.domain.repos

import com.android254.domain.models.Sponsors

interface SponsorsRepository
{
    fun fetchSponsors()

    fun getSponsors():List<Sponsors>
}