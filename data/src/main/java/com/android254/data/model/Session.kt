package com.android254.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity
data class Session(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val publishDate: Instant
)