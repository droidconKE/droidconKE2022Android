package com.android254.presentation.models

data class FeedPresentationModel(
    val title: String,
    val body: String,
    val topic: String,
    val url: String,
    val image: String?,
    val createdAt: String
)