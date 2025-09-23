package com.pules.app.data.repository.interfaces;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2 = {"Lcom/pules/app/data/repository/interfaces/ReadLaterRepository;", "", "getAllReadLaterItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pules/app/domain/model/ReadLaterItem;", "insertReadLaterItem", "", "item", "(Lcom/pules/app/domain/model/ReadLaterItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReadLaterItem", "itemId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReadLaterItemContent", "app_release"})
public abstract interface ReadLaterRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.domain.model.ReadLaterItem>> getAllReadLaterItems();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertReadLaterItem(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.model.ReadLaterItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteReadLaterItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getReadLaterItemContent(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
}