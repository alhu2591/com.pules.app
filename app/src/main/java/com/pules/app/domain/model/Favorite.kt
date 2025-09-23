package com.pules.app.domain.model

data class Favorite(
    val id: String,
    val title: String,
    val url: String,
    val imageUrl: String?,
    val publishedAt: Long,
    val sourceId: String
)




fun Favorite.toFavoriteEntity(): FavoriteEntity {
    return FavoriteEntity(
        id = this.id,
        title = this.title,
        url = this.url,
        imageUrl = this.imageUrl,
        publishedAt = this.publishedAt,
        sourceId = this.sourceId
    )
}

