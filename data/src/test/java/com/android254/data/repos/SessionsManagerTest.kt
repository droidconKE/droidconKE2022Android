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
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android254.data.dao.SessionDao
import com.android254.data.db.Database
import com.android254.data.network.apis.SessionRemoteSource
import com.android254.domain.models.DataResult
import com.android254.domain.models.Success
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SessionsManagerTest {
    private val mockApi = mockk<SessionRemoteSource>()
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
    fun `test it fetches and saves sessions successfully`() {
        val repo = SessionsManager(mockApi, dao)

        runBlocking {
            Assert.assertEquals(dao.fetchSessions().first(), true)
            coEvery { mockApi.fetchSessions(200) } returns results
            val result = repo.fetchAndSaveSessions(false)
            coVerify { mockApi.fetchSessions(200) }
            assertThat(result, CoreMatchers.`is`(DataResult.Success(Success)))
            Assert.assertEquals(dao.fetchSessions().first(), 1)
        }
    }

    @After
    fun afterTest() {
        database.close()
    }
}