package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(noteId: Int) {
        noteRepository.deleteNote(noteId)
    }
}


