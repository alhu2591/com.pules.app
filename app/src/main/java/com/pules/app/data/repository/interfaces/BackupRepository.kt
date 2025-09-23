package com.pules.app.data.repository.interfaces

import com.pules.app.data.model.BackupData
import kotlinx.coroutines.flow.Flow

interface BackupRepository {
    suspend fun createBackup(): Flow<BackupData>
    suspend fun restoreBackup(backupData: BackupData): Flow<Unit>
    suspend fun exportData(format: String): String
    suspend fun importData(data: String, format: String): Unit
}

