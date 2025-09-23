package com.pules.app.data.repository

import com.pules.app.data.local.dao.NoteDao
import com.pules.app.data.local.entity.NoteEntity
import com.pules.app.data.repository.interfaces.NoteRepository
import com.pules.app.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override fun getNotesForArticle(articleId: String): Flow<List<Note>> = noteDao.getNotesForArticle(articleId).map {
        it.map { entity ->
            Note(
                id = entity.id,
                articleId = entity.articleId,
                noteContent = entity.noteContent,
                timestamp = entity.timestamp
            )
        }
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(
            NoteEntity(
                id = note.id,
                articleId = note.articleId,
                noteContent = note.noteContent,
                timestamp = note.timestamp
            )
        )
    }

    override suspend fun deleteNote(noteId: Int) {
        noteDao.deleteNote(noteId)
    }
}


