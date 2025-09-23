package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.TagRepository
import javax.inject.Inject

class AddTagToArticleUseCase @Inject constructor(
    private val tagRepository: TagRepository
) {
    suspend operator fun invoke(articleId: String, tagId: Int) {
        tagRepository.addTagToArticle(articleId, tagId)
    }
}

