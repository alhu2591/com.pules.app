package com.pules.app.domain.usecase

import com.pules.app.data.model.BackupData
import com.pules.app.data.repository.interfaces.BackupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestoreBackupUseCase @Inject constructor(
    private val backupRepository: BackupRepository
) {
    suspend operator fun invoke(backupData: BackupData): Flow<Unit> {
        return backupRepository.restoreBackup(backupData)
    }
}

