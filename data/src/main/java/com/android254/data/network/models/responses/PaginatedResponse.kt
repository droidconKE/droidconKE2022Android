package com.android254.data.network.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class PaginatedResponse<ResponseData>(
    val data: ResponseData,
    val meta: ResponseMetaData
)