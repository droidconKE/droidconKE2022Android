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

import com.android254.data.dao.SessionDao
import com.android254.data.network.apis.SessionRemoteSource
import com.android254.data.network.util.NetworkError
import com.android254.data.repos.mappers.toDomainModel
import com.android254.data.repos.mappers.toEntity
import com.android254.domain.models.ResourceResult
import com.android254.domain.models.SessionDomainModel
import com.android254.domain.repos.SessionsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SessionsManager @Inject constructor(
    private val api: SessionRemoteSource,
    private val dao: SessionDao
) : SessionsRepo {
    override suspend fun fetchAndSaveSessions(fetchFromRemote: Boolean): Flow<ResourceResult<List<SessionDomainModel>>> {
        return flow {
            emit(ResourceResult.Loading(isLoading = true))
            val sessions = dao.fetchSessions()
            val isDbEmpty = sessions.isEmpty()
            emit(ResourceResult.Success(data = sessions.map {
                it.toDomainModel()
            }))
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(ResourceResult.Loading(isLoading = false))
                return@flow
            }

            try {
                val response = api.fetchSessions()
                val remoteSessions = response.data.flatMap { (_, value) -> value }
                if (remoteSessions.isEmpty()) {
                    emit(ResourceResult.Empty("No sessions just yet"))
                }
                remoteSessions.let {
                    dao.clearSessions()
                    val sessionEntities = it.map { session -> session.toEntity() }
                    dao.insert(sessionEntities)
                    emit(ResourceResult.Success(
                        data = sessionEntities.map { sessionEntity -> sessionEntity.toDomainModel() }
                    ))
                    emit(ResourceResult.Loading(isLoading = false))
                }
            } catch (e: Exception) {
                emit(ResourceResult.Loading(isLoading = true))
                when (e) {
                    is NetworkError -> emit(ResourceResult.Error("Network error"))
                    else -> emit(ResourceResult.Error("Error fetching sessions"))
                }
            }


        }
    }
}