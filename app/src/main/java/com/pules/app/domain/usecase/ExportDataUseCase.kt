package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.BackupRepository
import javax.inject.Inject

class ExportDataUseCase @Inject constructor(
    private val backupRepository: BackupRepository
) {
    suspend operator fun invoke(format: String): String {
        return backupRepository.exportData(format)
    }
}

