package com.pules.app.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u000e\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/pules/app/data/repository/BackupRepositoryImpl;", "Lcom/pules/app/data/repository/interfaces/BackupRepository;", "sourceDao", "error/NonExistentClass", "favoriteDao", "<init>", "(Lerror/NonExistentClass;Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "createBackup", "Lkotlinx/coroutines/flow/Flow;", "Lcom/pules/app/data/model/BackupData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreBackup", "", "backupData", "(Lcom/pules/app/data/model/BackupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportData", "", "format", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importData", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class BackupRepositoryImpl implements com.pules.app.data.repository.interfaces.BackupRepository {
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass sourceDao = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass favoriteDao = null;
    
    @javax.inject.Inject()
    public BackupRepositoryImpl(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass sourceDao, @org.jetbrains.annotations.NotNull()
    error.NonExistentClass favoriteDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createBackup(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.pules.app.data.model.BackupData>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object restoreBackup(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.model.BackupData backupData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<kotlin.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object exportData(@org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object importData(@org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}