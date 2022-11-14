package com.android254.data.db.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

class DateStringConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromLong(timestamp: Long): String {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault())
        return pattern.format(Instant.ofEpochMilli(timestamp))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromString(offsetDateTime: String): Long {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return LocalDateTime.parse(offsetDateTime, pattern).toInstant(ZoneOffset.ofHours(3))
            .toEpochMilli()
    }
}