package com.android254.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SponsorsEntity(
     var title: String?,
     var body: String?,
     var topic: String?,
     var url: String?,
     var image: String?,
     var createdAt: String?
    )
