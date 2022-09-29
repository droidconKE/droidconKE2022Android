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

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android254.data.network.apis.OrganizersApi
import com.android254.data.network.apis.OrganizersRemoteSource
import com.android254.data.network.models.responses.Organizer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrganizersRepository @Inject constructor(
    private val api: OrganizersApi
) {

    fun getOrganizers(): Flow<PagingData<Organizer>> = Pager(
        config = PagingConfig(pageSize = 10)
    ) {
        OrganizersRemoteSource(api = api)
    }.flow
}