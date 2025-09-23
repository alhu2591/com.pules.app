package com.pules.app.domain.model

data class ReadLaterItem(
    val id: String,
    val title: String,
    val url: String,
    val imageUrl: String?,
    val publishedAt: Long,
    val sourceId: String,
    val content: String? = null // Added for offline reading
)


