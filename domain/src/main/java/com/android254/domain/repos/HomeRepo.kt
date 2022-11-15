package com.android254.domain.repos

import com.android254.domain.models.HomeDetailsDomainModel

interface HomeRepo {
    suspend fun fetchHomeDetails(): HomeDetailsDomainModel
}