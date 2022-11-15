package com.android254.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
class BookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var session_slug: String,
)
