package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.ReadLaterRepository
import com.pules.app.domain.model.ReadLaterItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetReadLaterItemsUseCase @Inject constructor(
    private val readLaterRepository: ReadLaterRepository
) {
    operator fun invoke(): Flow<List<ReadLaterItem>> {
        return readLaterRepository.getAllReadLaterItems().map {
            it.map { entity ->
                ReadLaterItem(
                    id = entity.id,
                    title = entity.title,
                    url = entity.url,
                    imageUrl = entity.imageUrl,
                    publishedAt = entity.publishedAt,
                    sourceId = entity.sourceId
                )
            }
        }
    }
}


