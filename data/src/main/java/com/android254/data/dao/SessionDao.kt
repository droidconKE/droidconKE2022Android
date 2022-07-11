package com.android254.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.android254.data.model.Session

@Dao
interface SessionDao : BaseDao<Session> {

    @Query("SELECT * FROM SESSION")
    fun fetchSessions(): List<Session>
}