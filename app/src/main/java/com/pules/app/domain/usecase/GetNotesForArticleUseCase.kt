package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.NoteRepository
import com.pules.app.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesForArticleUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(articleId: String): Flow<List<Note>> {
        return noteRepository.getNotesForArticle(articleId)
    }
}


