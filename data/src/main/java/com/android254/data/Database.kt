package com.android254.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android254.data.dao.SessionDao
import com.android254.data.model.Session
import com.android254.data.util.InstantConverter

@Database(
    entities = [
        Session::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    InstantConverter::class
)
abstract class Database : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
}
