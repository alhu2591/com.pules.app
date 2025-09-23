package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.FavoriteRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(favoriteId: String) {
        favoriteRepository.deleteFavorite(favoriteId)
    }
}


