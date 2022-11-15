package com.android254.domain.repos

import com.android254.domain.models.HomeDetails

interface HomeRepo {
    suspend fun fetchHomeDetails(): HomeDetails
}