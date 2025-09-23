package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.ReadLaterRepository
import com.pules.app.domain.model.ReadLaterItem
import javax.inject.Inject

class AddReadLaterItemUseCase @Inject constructor(
    private val readLaterRepository: ReadLaterRepository
) {
    suspend operator fun invoke(item: ReadLaterItem) {
        readLaterRepository.insertReadLaterItem(item)
    }
}


