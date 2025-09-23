package com.pules.app.domain.usecase

import android.content.Context
import android.net.Uri
import com.pules.app.data.local.database.Dao.FavoriteDao
import com.pules.app.data.local.database.Dao.ReadLaterDao
import com.pules.app.data.local.database.Dao.SourceDao
import com.pules.app.data.local.database.entities.FavoriteEntity
import com.pules.app.data.local.database.entities.ReadLaterEntity
import com.pules.app.data.local.database.entities.SourceEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import javax.inject.Inject

class BackupRestoreUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val sourceDao: SourceDao,
    private val favoriteDao: FavoriteDao,
    private val readLaterDao: ReadLaterDao
) {

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val backupDataType = Types.newParameterizedType(
        BackupData::class.java,
        SourceEntity::class.java,
        FavoriteEntity::class.java,
        ReadLaterEntity::class.java
    )
    private val backupDataAdapter: JsonAdapter<BackupData> = moshi.adapter(backupDataType)

    suspend fun createBackup(uri: Uri): Result<Unit> = withContext(Dispatchers.IO) {
        return@withContext try {
            val sources = sourceDao.getAllSources().first()
            val favorites = favoriteDao.getAllFavorites().first()
            val readLaterItems = readLaterDao.getAllReadLaterItems().first()

            val backupData = BackupData(sources, favorites, readLaterItems)
            val json = backupDataAdapter.toJson(backupData)

            context.contentResolver.openOutputStream(uri)?.use {
                OutputStreamWriter(it).use { writer ->
                    writer.write(json)
                }
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun restoreBackup(uri: Uri): Result<Unit> = withContext(Dispatchers.IO) {
        return@withContext try {
            val json = context.contentResolver.openInputStream(uri)?.use {
                BufferedReader(InputStreamReader(it)).use { reader ->
                    reader.readText()
                }
            }

            if (json.isNullOrEmpty()) {
                return@withContext Result.failure(Exception("Backup file is empty or unreadable."))
            }

            val backupData = backupDataAdapter.fromJson(json)
                ?: return@withContext Result.failure(Exception("Failed to parse backup data."))

            sourceDao.deleteAllSources()
            backupData.sources.forEach { sourceDao.insertSource(it) }

            favoriteDao.deleteAllFavorites()
            backupData.favorites.forEach { favoriteDao.insertFavorite(it) }

            readLaterDao.deleteAllReadLaterItems()
            backupData.readLaterItems.forEach { readLaterDao.insertReadLaterItem(it) }

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    data class BackupData(
        val sources: List<SourceEntity>,
        val favorites: List<FavoriteEntity>,
        val readLaterItems: List<ReadLaterEntity>
    )
}


