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
package com.android254.data.db.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class InstantConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    fun longToInstant(value: Long?): Instant? =
        value?.let(Instant::fromEpochMilliseconds)

    @TypeConverter
    fun instantToLong(instant: Instant?): Long? =
        instant?.toEpochMilliseconds()

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toOffsetDateTime(string: String?): OffsetDateTime? = string?.let {
        formatter.parse(it, OffsetDateTime::from)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromOffsetDateTime(offsetDateTime: OffsetDateTime?): String? =
        offsetDateTime?.format(formatter)
}