package com.android254.data.network.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class GenericPaginatedResponse<ResponseData>(
    val data: List<ResponseData>,
    val meta: ResponseMetaData
)
