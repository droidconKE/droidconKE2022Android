package com.android254.data.repos.mappers

import com.android254.data.db.model.Session
import com.android254.data.network.models.responses.SessionApiModel
import com.android254.domain.models.SessionDomainModel

fun Session.toDomainModel() = SessionDomainModel(
    id = this.id,
    description = this.description,
    title = this.title,
    session_format = this.session_format,
    session_level = this.session_level,
    slug = this.slug
)

fun SessionApiModel.toEntity() = Session(
    id = 0,
    description = description,
    title = title,
    session_format = session_format,
    session_level = session_level,
    slug = slug
)