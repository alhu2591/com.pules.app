package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.SourceRepository
import javax.inject.Inject

class RemoveSourceUseCase @Inject constructor(
    private val sourceRepository: SourceRepository
) {
    suspend operator fun invoke(sourceId: String) {
        sourceRepository.deleteSource(sourceId)
    }
}


