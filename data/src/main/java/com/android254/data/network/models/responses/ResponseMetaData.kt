package com.android254.data.network.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class ResponseMetaData(
    val paginator: PaginationMetaData
)
