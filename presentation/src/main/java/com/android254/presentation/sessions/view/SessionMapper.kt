package com.android254.presentation.sessions.view

import com.android254.domain.models.SessionDomainModel
import com.android254.presentation.models.SessionPresentationModel


fun SessionDomainModel.toPresentationModel() = SessionPresentationModel(
    id = this.id.toString(),
    sessionTitle = this.title,
    sessionDescription = this.description,
    sessionVenue = "",
    sessionSpeakerImage = "",
    sessionSpeakerName = "",
    sessionStartTime = "",
    sessionEndTime = "",
    amOrPm = "",
    isStarred = false,
)