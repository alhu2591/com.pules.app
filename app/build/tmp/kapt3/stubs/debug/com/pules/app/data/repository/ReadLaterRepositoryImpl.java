package com.pules.app.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/pules/app/data/repository/ReadLaterRepositoryImpl;", "Lcom/pules/app/data/repository/interfaces/ReadLaterRepository;", "readLaterDao", "error/NonExistentClass", "<init>", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "getAllReadLaterItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pules/app/domain/model/ReadLaterItem;", "insertReadLaterItem", "", "item", "(Lcom/pules/app/domain/model/ReadLaterItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReadLaterItem", "itemId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReadLaterItemContent", "app_debug"})
public final class ReadLaterRepositoryImpl implements com.pules.app.data.repository.interfaces.ReadLaterRepository {
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass readLaterDao = null;
    
    @javax.inject.Inject()
    public ReadLaterRepositoryImpl(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass readLaterDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.domain.model.ReadLaterItem>> getAllReadLaterItems() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertReadLaterItem(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.model.ReadLaterItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteReadLaterItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getReadLaterItemContent(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}