package com.pules.app.presentation.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/pules/app/presentation/ui/viewmodel/NotesViewModel;", "Landroidx/lifecycle/ViewModel;", "addNoteUseCase", "Lcom/pules/app/domain/usecase/AddNoteUseCase;", "getNotesForArticleUseCase", "Lcom/pules/app/domain/usecase/GetNotesForArticleUseCase;", "deleteNoteUseCase", "Lcom/pules/app/domain/usecase/DeleteNoteUseCase;", "<init>", "(Lcom/pules/app/domain/usecase/AddNoteUseCase;Lcom/pules/app/domain/usecase/GetNotesForArticleUseCase;Lcom/pules/app/domain/usecase/DeleteNoteUseCase;)V", "getNotesForArticle", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pules/app/domain/model/Note;", "articleId", "", "addNote", "", "note", "deleteNote", "noteId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NotesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.AddNoteUseCase addNoteUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetNotesForArticleUseCase getNotesForArticleUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.DeleteNoteUseCase deleteNoteUseCase = null;
    
    @javax.inject.Inject()
    public NotesViewModel(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.AddNoteUseCase addNoteUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetNotesForArticleUseCase getNotesForArticleUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.DeleteNoteUseCase deleteNoteUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.domain.model.Note>> getNotesForArticle(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId) {
        return null;
    }
    
    public final void addNote(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.model.Note note) {
    }
    
    public final void deleteNote(int noteId) {
    }
}