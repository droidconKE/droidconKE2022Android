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

import com.android254.data.dao.OrganizersDao
import com.android254.data.network.apis.OrganizersApi
import com.android254.data.util.OrganizerDataToDomainMapper.toDomain
import com.android254.data.util.OrganizerDomainToEntityMapper.toDomain
import com.android254.data.util.OrganizerDomainToEntityMapper.toEntity
import com.android254.domain.repos.OrganizersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class OrganizersSource @Inject constructor(
    private val api: OrganizersApi,
    private val dao: OrganizersDao
) : OrganizersRepository {

    private fun getPagedOrganizers(page: Int = 1) {
        CoroutineScope(Dispatchers.IO).launch {

            val response = api.fetchOrganizers(perPage = 10, page = page) ?: return@launch

            val organizers = response.data

            organizers.forEach {
                dao.insert(it.toDomain().toEntity())
            }

            if (response.meta?.paginator?.hasMorePages == true) {
                getPagedOrganizers(page = page + 1)
            }
        }
    }

    override fun fetchOrganizers() {
        getPagedOrganizers(page = 1)
    }

    override fun getOrganizers() = dao.fetchSessions().map { it.toDomain() }
}