package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.BackupRepository
import javax.inject.Inject

class ImportDataUseCase @Inject constructor(
    private val backupRepository: BackupRepository
) {
    suspend operator fun invoke(data: String, format: String) {
        backupRepository.importData(data, format)
    }
}

