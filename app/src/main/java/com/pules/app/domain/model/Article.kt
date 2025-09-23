package com.pules.app.domain.model

data class Article(
    val id: String,
    val title: String,
    val description: String?,
    val url: String,
    val imageUrl: String?,
    val publishedAt: Long,
    val sourceName: String,
    val category: String? = null // Added for classification
)


