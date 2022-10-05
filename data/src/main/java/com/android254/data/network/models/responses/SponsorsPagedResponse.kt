package com.android254.data.network.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class SponsorsPagedResponse(
    @SerialName("data") var data: List<Sponsors>,
    @SerialName("meta") var meta: Meta?
)

@Serializable
data class Sponsors(
    @SerialName("title") var title: Int?,
    @SerialName("body") var body: String?,
    @SerialName("topic") var topic: String?,
    @SerialName("url") var url: String?,
    @SerialName("image") var image: String?,
    @SerialName("created_at") var createdAt: String?,

)

@Serializable
data class Creator(
    @SerialName("id") var id: Int?,
    @SerialName("name") var name: String?,
    @SerialName("email") var email: String?,
    @SerialName("created_at") var createdAt: String?
)

@Serializable
data class Paginator(
    @SerialName("count") var count: Int? = null,
    @SerialName("per_page") var perPage: String? = null,
    @SerialName("current_page") var currentPage: Int? = null,
    @SerialName("next_page") var nextPage: String? = null,
    @SerialName("has_more_pages") var hasMorePages: Boolean? = null,
    @SerialName("next_page_url") var nextPageUrl: String? = null,
    @SerialName("previous_page_url") var previousPageUrl: String? = null
)

@Serializable
data class Meta(
    @SerialName("paginator") var paginator: Paginator?
)