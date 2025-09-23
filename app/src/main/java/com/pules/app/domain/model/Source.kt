package com.pules.app.domain.model

data class Source(
    val id: String,
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




fun Source.toSourceEntity(): SourceEntity {
    return SourceEntity(
        id = this.id,
        name = this.name,
        url = this.url,
        description = this.description,
        imageUrl = this.imageUrl,
        category = this.category,
        language = this.language,
        country = this.country,
        isFollowed = this.isFollowed,
        channelName = this.channelName,
        subscriberCount = this.subscriberCount
    )
}

