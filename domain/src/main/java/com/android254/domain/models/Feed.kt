package com.android254.domain.models


data class Feed(
    val title: String,
    val body: String,
    val topic: String,
    val url: String,
    val image: String?,
    val createdAt: String
)
