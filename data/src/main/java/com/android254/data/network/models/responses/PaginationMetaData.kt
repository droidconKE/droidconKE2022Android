package com.android254.data.network.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class PaginationMetaData(
    val count: Int,
    val current_page: Int,
    val has_more_pages: Boolean,
    val next_page: String,
    val next_page_url: String,
    val per_page: String,
    val previous_page_url: String
)