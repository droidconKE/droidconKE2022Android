package com.android254.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.android254.data.db.model.SponsorsEntity

@Dao
interface SponsorDao: BaseDao<SponsorsEntity> {
    @Query("SELECT * FROM SESSION")
    fun fetchSponsors(): List<SponsorsEntity>


}