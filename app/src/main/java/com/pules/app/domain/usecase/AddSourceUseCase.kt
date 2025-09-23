package com.pules.app.domain.usecase

import com.pules.app.data.local.entity.SourceEntity
import com.pules.app.data.repository.interfaces.SourceRepository
import com.pules.app.domain.model.Source
import javax.inject.Inject

class AddSourceUseCase @Inject constructor(
    private val sourceRepository: SourceRepository
) {
    suspend operator fun invoke(source: Source) {
        sourceRepository.insertSource(SourceEntity(
            id = source.id,
            name = source.name,
            url = source.url,
            description = source.description,
            imageUrl = source.imageUrl,
            category = source.category,
            language = source.language,
            country = source.country,
            isFollowed = source.isFollowed
        ))
    }
}


