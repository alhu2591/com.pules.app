package com.pules.app.data.local.database.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010\u00c0\u0006\u0003"}, d2 = {"Lcom/pules/app/data/local/database/dao/NoteDao;", "", "getNotesForArticle", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pules/app/data/local/database/entity/NoteEntity;", "articleId", "", "insertNote", "", "note", "(Lcom/pules/app/data/local/database/entity/NoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNote", "noteId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface NoteDao {
    
    @androidx.room.Query(value = "SELECT * FROM notes WHERE articleId = :articleId ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.data.local.database.entity.NoteEntity>> getNotesForArticle(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.local.database.entity.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM notes WHERE id = :noteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNote(int noteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}