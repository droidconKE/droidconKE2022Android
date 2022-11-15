package com.android254.domain.repos

import com.android254.domain.models.FeedDomainModel
import com.android254.domain.models.ResourceResult

interface FeedRepo {
    suspend fun fetchFeed(): ResourceResult<List<FeedDomainModel>>
}