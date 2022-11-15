package com.android254.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.android254.data.db.model.BookmarkEntity
import com.android254.data.db.model.SessionEntity

@Dao
interface BookmarkDao : BaseDao<BookmarkEntity> {
    @Query("SELECT * FROM bookmarks")
    fun getBookmarkIds() : List<BookmarkEntity>
}