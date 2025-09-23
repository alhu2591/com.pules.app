package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.FavoriteRepository
import com.pules.app.domain.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke(): Flow<List<Favorite>> {
        return favoriteRepository.getAllFavorites().map {
            it.map { entity ->
                Favorite(
                    id = entity.id,
                    title = entity.title,
                    url = entity.url,
                    imageUrl = entity.imageUrl,
                    publishedAt = entity.publishedAt,
                    sourceId = entity.sourceId
                )
            }
        }
    }
}


