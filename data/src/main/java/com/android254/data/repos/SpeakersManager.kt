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
package com.android254.data.repos

import com.android254.data.db.Database
import com.android254.data.network.apis.SpeakersApi
import com.android254.data.repos.mappers.toDomainModel
import com.android254.data.repos.mappers.toEntity
import com.android254.domain.models.DataResult
import com.android254.domain.models.ResourceResult
import com.android254.domain.models.Speaker
import com.android254.domain.repos.SpeakersRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpeakersManager @Inject constructor(
    db: Database,
    private val api: SpeakersApi
) : SpeakersRepo {
    val speakerDao = db.speakerDao()

    override suspend fun fetchSpeakers(): ResourceResult<List<Speaker>> = withContext(Dispatchers.IO){
        val speakers = speakerDao.fetchSpeakers()
        if (speakers.isEmpty()) {
            when (val result = api.fetchSpeakers()) {
                is DataResult.Success -> {
                    val data = result.data.data
                    if (data.isEmpty()) {
                        ResourceResult.Empty()
                    }
                    speakerDao.insert(data.map { it.toEntity() })
                }
                is DataResult.Error -> {
                    return@withContext ResourceResult.Error(
                        result.message,
                        networkError = result.message.contains("network", ignoreCase = true)
                    )
                }
                else -> {
                }
            }
        }
        return@withContext ResourceResult.Success(speakerDao.fetchSpeakers().map { it.toDomainModel() })
    }

    override suspend fun fetchSpeakerCount(): ResourceResult<Int> {
        return ResourceResult.Success(speakerDao.fetchSpeakerCount())
    }
}