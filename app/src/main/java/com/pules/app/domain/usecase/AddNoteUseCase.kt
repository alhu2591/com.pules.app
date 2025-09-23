package com.pules.app.domain.usecase

import com.pules.app.data.repository.interfaces.NoteRepository
import com.pules.app.domain.model.Note
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        noteRepository.insertNote(note)
    }
}


