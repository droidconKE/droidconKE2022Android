package com.android254.presentation.feed.view

import com.android254.domain.models.FeedDomainModel
import com.android254.presentation.models.FeedPresentationModel

fun FeedDomainModel.toPresentation() = FeedPresentationModel (
    title = title,
    body = body,
    topic = topic,
    url = url,
    image = image,
    createdAt = createdAt
        )