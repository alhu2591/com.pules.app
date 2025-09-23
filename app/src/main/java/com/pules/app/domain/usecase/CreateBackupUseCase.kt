package com.pules.app.domain.usecase

import com.pules.app.data.model.BackupData
import com.pules.app.data.repository.interfaces.BackupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateBackupUseCase @Inject constructor(
    private val backupRepository: BackupRepository
) {
    suspend operator fun invoke(): Flow<BackupData> {
        return backupRepository.createBackup()
    }
}

