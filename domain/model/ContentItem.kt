package com.pules.app.domain.model

data class ContentItem(
    val id: String,
    val title: String,
    val description: String?,
    val thumbnailUrl: String?,
    val contentUrl: String,
    val publishedAt: Long,
    val sourceType: SourceType,
    val sourceName: String,
    val sourceImageUrl: String?
)


