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
package com.android254.data.network.apis

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android254.data.network.models.responses.Organizer

class OrganizersRemoteSource(
    private val api: OrganizersApi
) : PagingSource<Int, Organizer>() {

    override fun getRefreshKey(state: PagingState<Int, Organizer>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Organizer> {

        return try {
            // should be converted to a constant
            val perPage = 10
            val start = params.key ?: 1
            val response = api.fetchOrganizers(perPage = perPage, page = start)

            val paginator = response.meta?.paginator
            val list = response.data

            val nextPage = when (paginator?.hasMorePages == true) {
                true -> paginator?.currentPage?.plus(1)
                false -> null
            }

            val previousPage = when (paginator?.previousPageUrl != null) {
                true -> paginator?.currentPage?.minus(1)
                false -> null
            }

            return LoadResult.Page(
                data = list,
                prevKey = previousPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}