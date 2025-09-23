package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.ReadLaterRepository
import javax.inject.Inject

class RemoveReadLaterItemUseCase @Inject constructor(
    private val readLaterRepository: ReadLaterRepository
) {
    suspend operator fun invoke(itemId: String) {
        readLaterRepository.deleteReadLaterItem(itemId)
    }
}


