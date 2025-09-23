package com.pules.app.data.repository

import com.pules.app.data.local.dao.FavoriteDao
import com.pules.app.data.local.dao.SourceDao
import com.pules.app.data.model.BackupData
import com.pules.app.data.repository.interfaces.BackupRepository
import com.pules.app.domain.model.toFavorite
import com.pules.app.domain.model.toFavoriteEntity
import com.pules.app.domain.model.toSource
import com.pules.app.domain.model.toSourceEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class BackupRepositoryImpl @Inject constructor(
    private val sourceDao: SourceDao,
    private val favoriteDao: FavoriteDao
) : BackupRepository {

    override suspend fun createBackup(): Flow<BackupData> = flow {
        val sources = sourceDao.getAllSources().firstOrNull()?.map { it.toSource() } ?: emptyList()
        val favorites = favoriteDao.getAllFavorites().firstOrNull()?.map { it.toFavorite() } ?: emptyList()
        emit(BackupData(sources, favorites))
    }

    override suspend fun restoreBackup(backupData: BackupData): Flow<Unit> = flow {
        sourceDao.deleteAllSources()
        sourceDao.insertAllSources(backupData.sources.map { it.toSourceEntity() })

        favoriteDao.deleteAllFavorites()
        favoriteDao.insertAllFavorites(backupData.favorites.map { it.toFavoriteEntity() })
        emit(Unit)
    }

    override suspend fun exportData(format: String): String {
        val sources = sourceDao.getAllSources().firstOrNull()?.map { it.toSource() } ?: emptyList()
        val favorites = favoriteDao.getAllFavorites().firstOrNull()?.map { it.toFavorite() } ?: emptyList()
        val backupData = BackupData(sources, favorites)
        return when (format) {
            "json" -> Json.encodeToString(backupData)
            "pdf" -> "PDF export not yet implemented"
            else -> throw IllegalArgumentException("Unsupported format")
        }
    }

    override suspend fun importData(data: String, format: String) {
        when (format) {
            "json" -> {
                val backupData = Json.decodeFromString<BackupData>(data)
                sourceDao.deleteAllSources()
                sourceDao.insertAllSources(backupData.sources.map { it.toSourceEntity() })
                favoriteDao.deleteAllFavorites()
                favoriteDao.insertAllFavorites(backupData.favorites.map { it.toFavoriteEntity() })
            }
            "pdf" -> throw IllegalArgumentException("PDF import not yet implemented")
            else -> throw IllegalArgumentException("Unsupported format")
        }
    }
}

