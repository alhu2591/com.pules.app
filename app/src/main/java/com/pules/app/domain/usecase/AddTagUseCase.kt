package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.TagRepository
import com.pules.app.domain.model.Tag
import javax.inject.Inject

class AddTagUseCase @Inject constructor(
    private val tagRepository: TagRepository
) {
    suspend operator fun invoke(tag: Tag): Long {
        return tagRepository.addTag(tag)
    }
}

