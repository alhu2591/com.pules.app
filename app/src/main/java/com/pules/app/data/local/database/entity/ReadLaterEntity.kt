package com.pules.app.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "read_later_items")
data class ReadLaterEntity(
    @PrimaryKey val id: String,
    val title: String,
    val url: String,
    val imageUrl: String?,
    val publishedAt: Long,
    val sourceId: String,
    val content: String? // Added for offline reading
)


