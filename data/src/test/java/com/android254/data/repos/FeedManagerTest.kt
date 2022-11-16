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

import com.android254.data.network.apis.FeedApi
import com.android254.domain.models.DataResult
import com.android254.domain.models.ResourceResult
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FeedManagerTest {
    private val mockApi = mockk<FeedApi>()

    @Test
    fun `test feeds are fetched successfully`() {
        runBlocking {
            val repo = FeedManager(mockApi)
            coEvery { mockApi.fetchFeed(1, 100) } returns DataResult.Success(feed)
            val result = repo.fetchFeed()
            coVerify { mockApi.fetchFeed(1, 100) }
            MatcherAssert.assertThat(result, CoreMatchers.instanceOf(ResourceResult.Success::class.java))
        }
    }
}