package com.android254.data.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.android254.data.Database
import com.android254.data.model.Session
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

    @OptIn(ExperimentalCoroutinesApi::class)
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