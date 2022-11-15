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