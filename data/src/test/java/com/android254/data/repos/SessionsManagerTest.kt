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

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.android254.data.dao.SessionDao
import com.android254.data.db.Database
<<<<<<< HEAD
import com.android254.data.network.apis.SessionsApi
=======
import com.android254.data.db.model.SessionEntity
import com.android254.data.network.util.NetworkError
import com.android254.domain.models.ResourceResult
>>>>>>> f76e78fe318e8873cacf788ca95e5788ffa836ca
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SessionsManagerTest {
    private val mockApi = mockk<SessionsApi>()
    private lateinit var dao: SessionDao
    private lateinit var database: Database

    @Before
    fun beforeTest() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            Database::class.java
        ).allowMainThreadQueries().build()

        dao = database.sessionDao()
    }

    @Test
    fun `test network errors are properly handled`() {
        runBlocking {
<<<<<<< HEAD
            Assert.assertEquals(dao.fetchSessions().first(), true)
            coEvery { mockApi.fetchSessions() } returns results
            val result = repo.fetchAndSaveSessions(false)
            coVerify { mockApi.fetchSessions() }
            assertThat(result, CoreMatchers.`is`(DataResult.Success(Success)))
            Assert.assertEquals(dao.fetchSessions().first(), 1)
=======
            coEvery { mockApi.fetchSessions(any()) } throws NetworkError()
            val repo = SessionsManager(mockApi, dao)
            val results = repo.fetchAndSaveSessions()
            assertThat(results, `is`(ResourceResult.Error("Network error", networkError = true)))
        }
    }

    @Test
    fun `test other errors are properly handled`() {
        runBlocking {
            coEvery { mockApi.fetchSessions(any()) } throws Exception()
            val repo = SessionsManager(mockApi, dao)
            val results = repo.fetchAndSaveSessions()
            assertThat(
                results,
                `is`(ResourceResult.Error("Error fetching sessions", networkError = false))
            )
        }
    }

    @Test
    fun `test it fetches and saves sessions successfully`() {
        runBlocking {
            val repo = SessionsManager(mockApi, dao)
            coEvery { mockApi.fetchSessions(200) } returns results
            val result = repo.fetchAndSaveSessions()
            coVerify { mockApi.fetchSessions(200) }
            assertThat(result, CoreMatchers.instanceOf(ResourceResult.Success::class.java))
            assertEquals(
                listOf(
                    SessionEntity(
                        id = 1,
                        description = "1",
                        session_format = "",
                        session_level = "",
                        slug = "new title",
                        title = "",
                        sessionImageUrl = "",
                        sessionRoom = "",
                        speakerName = ""
                    )
                ),
                dao.fetchSessions().first()
            )
>>>>>>> f76e78fe318e8873cacf788ca95e5788ffa836ca
        }
    }

    @After
    fun afterTest() {
        database.close()
    }
}