package com.pules.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.domain.model.Note
import com.pules.app.domain.usecase.AddNoteUseCase
import com.pules.app.domain.usecase.DeleteNoteUseCase
import com.pules.app.domain.usecase.GetNotesForArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val getNotesForArticleUseCase: GetNotesForArticleUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    fun getNotesForArticle(articleId: String): Flow<List<Note>> {
        return getNotesForArticleUseCase(articleId)
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }

    fun deleteNote(noteId: Int) {
        viewModelScope.launch {
            deleteNoteUseCase(noteId)
        }
    }
}


