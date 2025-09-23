package com.pules.app.domain.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/pules/app/domain/usecase/GetNotesForArticleUseCase;", "", "noteRepository", "Lcom/pules/app/data/repository/interfaces/NoteRepository;", "<init>", "(Lcom/pules/app/data/repository/interfaces/NoteRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pules/app/domain/model/Note;", "articleId", "", "app_debug"})
public final class GetNotesForArticleUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.data.repository.interfaces.NoteRepository noteRepository = null;
    
    @javax.inject.Inject()
    public GetNotesForArticleUseCase(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.repository.interfaces.NoteRepository noteRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.domain.model.Note>> invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId) {
        return null;
    }
}