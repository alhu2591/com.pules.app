package com.pules.app.domain.model

data class Source(
    val id: Int = 0,
    val name: String,
    val url: String,
    val type: SourceType,
    val imageUrl: String? = null,
    val followersCount: Int? = null,
    val lastContentDate: Long? = null
)

enum class SourceType {
    YOUTUBE,
    TWITTER
}


