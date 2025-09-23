package com.pules.app.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sources")
data class SourceEntity(
    @PrimaryKey val id: String,
    val name: String,
    val url: String,
    val description: String?,
    val imageUrl: String?,
    val category: String?,
    val language: String?,
    val country: String?,
    val isFollowed: Boolean = false,
    val channelName: String? = null,
    val subscriberCount: String? = null
)


