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

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.sqlite.db.SimpleSQLiteQuery
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
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun fetchAndSaveSessions(
        fetchFromRemote: Boolean,
        query: String?
    ): Flow<ResourceResult<List<SessionDomainModel>>> {
        return flow {
            emit(ResourceResult.Loading(isLoading = true))
            val sessions = if (query == null) {
                dao.fetchSessions()
            } else {
                dao.fetchSessionsWithFilters(SimpleSQLiteQuery(query))
            }

            val isDbEmpty = sessions.isEmpty()
            val hasAQuery = query != null
            emit(
                ResourceResult.Success(
                    data = sessions.map {
                        it.toDomainModel()
                    }
                )
            )
            val shouldLoadFromCache = (!isDbEmpty && !fetchFromRemote) || hasAQuery
            if (shouldLoadFromCache) {
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
                    emit(
                        ResourceResult.Success(
                            data = sessionEntities.map { sessionEntity -> sessionEntity.toDomainModel() }
                        )
                    )
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

    override suspend fun fetchSessionById(id: String): Flow<ResourceResult<SessionDomainModel>> {
        return flow {
            emit(ResourceResult.Loading(isLoading = true))
            val session = dao.getSessionById(id)
            if (session == null) {
                emit(ResourceResult.Loading(isLoading = false))
                emit(ResourceResult.Error(message = "requested event no longer available"))
                return@flow
            }
            emit(ResourceResult.Loading(isLoading = false))
            emit(ResourceResult.Success(data = session.toDomainModel()))
            return@flow
        }
    }

    override suspend fun toggleBookmarkStatus(id: String): Flow<ResourceResult<Boolean>> {

        return flow {
            try {
                api.updateBookmarkedStatus(id)
                dao.updateBookmarkedStatus(id, false)
            } catch (e: Exception) {
                emit(ResourceResult.Loading(isLoading = true))
                when (e) {
                    is NetworkError -> {
                        emit(ResourceResult.Error("Network error"))
                    }
                    else -> {
                        emit(ResourceResult.Error("Error fetching sessions"))
                    }
                }
            }
            emit(ResourceResult.Success(data = true))
        }
    }
}