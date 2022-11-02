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
package com.android254.data.dao

import com.android254.data.db.model.Session
import com.google.common.truth.Truth
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SessionDaoTest {
    private lateinit var session: Session
    @MockK
    private lateinit var sessionDao: SessionDao

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        session = Session(
            id = 0,
            title = "Retrofiti: A Pragmatic Approach to using Retrofit in Android",
            description = "This session is codelab covering some of the best practices and recommended approaches to building an application using the retrofit library.",
            slug = "retrofiti-a-pragmatic-approach-to-using-retrofit-in-android-1583941090",
            session_format = "Codelab / Workshop",
            session_level = "Intermediate",
        )

        coJustRun { sessionDao.insert(session) }
        coEvery { sessionDao.fetchSessions() } returns flow { emit(listOf(session)) }
    }

    @Test
    fun `test sessionDao fetches all sessions`() = runTest {
        // Given
        sessionDao.insert(session)

        // When
        val result = sessionDao.fetchSessions().first()

        // Then
        coVerify(atLeast = 1) { sessionDao.insert(session) }
        coVerify { sessionDao.insert(session) }
        Truth.assertThat(result.first().title).isEqualTo(session.title)
    }
}