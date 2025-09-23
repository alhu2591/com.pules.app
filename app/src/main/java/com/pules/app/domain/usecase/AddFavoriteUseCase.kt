package com.pules.app.domain.usecase

import com.pules.app.data.local.entity.FavoriteEntity
import com.pules.app.data.repository.interfaces.FavoriteRepository
import com.pules.app.domain.model.Favorite
import javax.inject.Inject

class AddFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(favorite: Favorite) {
        favoriteRepository.insertFavorite(FavoriteEntity(
            id = favorite.id,
            title = favorite.title,
            url = favorite.url,
            imageUrl = favorite.imageUrl,
            publishedAt = favorite.publishedAt,
            sourceId = favorite.sourceId
        ))
    }
}


