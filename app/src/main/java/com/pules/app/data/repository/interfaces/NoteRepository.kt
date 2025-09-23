package com.pules.app.data.repository.interfaces

import com.pules.app.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotesForArticle(articleId: String): Flow<List<Note>>
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(noteId: Int)
}


