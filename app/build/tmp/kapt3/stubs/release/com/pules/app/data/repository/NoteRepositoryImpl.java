package com.pules.app.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/pules/app/data/repository/NoteRepositoryImpl;", "Lcom/pules/app/data/repository/interfaces/NoteRepository;", "noteDao", "error/NonExistentClass", "<init>", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "getNotesForArticle", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pules/app/domain/model/Note;", "articleId", "", "insertNote", "", "note", "(Lcom/pules/app/domain/model/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNote", "noteId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class NoteRepositoryImpl implements com.pules.app.data.repository.interfaces.NoteRepository {
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass noteDao = null;
    
    @javax.inject.Inject()
    public NoteRepositoryImpl(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass noteDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.domain.model.Note>> getNotesForArticle(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.model.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteNote(int noteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}