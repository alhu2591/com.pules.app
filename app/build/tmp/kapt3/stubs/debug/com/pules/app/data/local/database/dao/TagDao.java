package com.pules.app.data.local.database.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010\u0014\u001a\u00020\fH\'J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001b\u00c0\u0006\u0003"}, d2 = {"Lcom/pules/app/data/local/database/dao/TagDao;", "", "insertTag", "", "tag", "Lcom/pules/app/data/local/database/entity/TagEntity;", "(Lcom/pules/app/data/local/database/entity/TagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTags", "Lkotlinx/coroutines/flow/Flow;", "", "getTagByName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertArticleTagCrossRef", "", "crossRef", "Lcom/pules/app/data/local/database/entity/ArticleTagCrossRef;", "(Lcom/pules/app/data/local/database/entity/ArticleTagCrossRef;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagsForArticle", "articleId", "deleteTag", "tagId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticleTagCrossRef", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface TagDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTag(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.local.database.entity.TagEntity tag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tags")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.data.local.database.entity.TagEntity>> getAllTags();
    
    @androidx.room.Query(value = "SELECT * FROM tags WHERE name = :name")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTagByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pules.app.data.local.database.entity.TagEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertArticleTagCrossRef(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.local.database.entity.ArticleTagCrossRef crossRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT T.name FROM tags T INNER JOIN ArticleTagCrossRef ATC ON T.id = ATC.tagId WHERE ATC.articleId = :articleId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getTagsForArticle(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId);
    
    @androidx.room.Query(value = "DELETE FROM tags WHERE id = :tagId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTag(int tagId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM ArticleTagCrossRef WHERE articleId = :articleId AND tagId = :tagId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteArticleTagCrossRef(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, int tagId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}