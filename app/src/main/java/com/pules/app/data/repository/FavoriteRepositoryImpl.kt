package com.pules.app.data.repository

import com.pules.app.data.local.dao.FavoriteDao
import com.pules.app.data.local.entity.FavoriteEntity
import com.pules.app.data.repository.interfaces.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) : FavoriteRepository {
    override fun getAllFavorites(): Flow<List<FavoriteEntity>> = favoriteDao.getAllFavorites()

    override suspend fun insertFavorite(favorite: FavoriteEntity) {
        favoriteDao.insertFavorite(favorite)
    }

    override suspend fun deleteFavorite(favoriteId: String) {
        favoriteDao.deleteFavorite(favoriteId)
    }
}


