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

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.android254.data.db.Database
import com.android254.data.db.model.Session
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.toInstant
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class SessionDaoTest {

    private lateinit var sessionDao: SessionDao
    private lateinit var db: Database

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            Database::class.java
        )
            .allowMainThreadQueries() // TODO Please delete me
            .build()
        sessionDao = db.sessionDao()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        db.close()
    }

    @Test
    fun sessionDao_fetches_all_sessions() = runTest {
        val session = Session(0, "Welcome Keynote", "2010-06-01T22:19:44.475Z".toInstant())
        sessionDao.insert(
            session
        )

        val result = sessionDao.fetchSessions().first()

        Assert.assertEquals(session.name, result.name)
    }
}