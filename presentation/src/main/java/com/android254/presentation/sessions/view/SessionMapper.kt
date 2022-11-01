/*
 * Copyright 2022 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.presentation.sessions.view

import android.os.Build
import androidx.annotation.RequiresApi
import com.android254.domain.models.SessionDomainModel
import com.android254.presentation.models.SessionPresentationModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun SessionDomainModel.toPresentationModel(): SessionPresentationModel {
    val startTime = getTimePeriod(this.start_date_time)
    return SessionPresentationModel(
        id = this.id.toString(),
        sessionTitle = this.title,
        sessionDescription = this.description,
        sessionVenue = "",
        sessionSpeakerImage = "",
        sessionSpeakerName = "",
        sessionStartTime = startTime.time,
        sessionEndTime = this.end_time,
        amOrPm = startTime.period,
        isStarred = false,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getTimePeriod(time: String): FormattedTime {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss")
    val localDate = LocalDate.parse(time, formatter)
    return FormattedTime(
       "08:45",
        "AM"
    )
}

data class FormattedTime(
    val time: String,
    val period: String
)