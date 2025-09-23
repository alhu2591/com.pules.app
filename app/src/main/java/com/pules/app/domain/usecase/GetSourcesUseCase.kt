package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.SourceRepository
import com.pules.app.domain.model.Source
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSourcesUseCase @Inject constructor(
    private val sourceRepository: SourceRepository
) {
    operator fun invoke(): Flow<List<Source>> {
        return sourceRepository.getAllSources().map {
            it.map { entity ->
                Source(
                    id = entity.id,
                    name = entity.name,
                    url = entity.url,
                    description = entity.description,
                    imageUrl = entity.imageUrl,
                    category = entity.category,
                    language = entity.language,
                    country = entity.country,
                    isFollowed = entity.isFollowed
                )
            }
        }
    }
}


