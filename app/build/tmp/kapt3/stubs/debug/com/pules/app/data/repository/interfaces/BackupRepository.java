package com.pules.app.data.repository.interfaces;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011\u00c0\u0006\u0003"}, d2 = {"Lcom/pules/app/data/repository/interfaces/BackupRepository;", "", "createBackup", "Lkotlinx/coroutines/flow/Flow;", "Lcom/pules/app/data/model/BackupData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreBackup", "", "backupData", "(Lcom/pules/app/data/model/BackupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportData", "", "format", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importData", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface BackupRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createBackup(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.pules.app.data.model.BackupData>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object restoreBackup(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.model.BackupData backupData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<kotlin.Unit>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object exportData(@org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object importData(@org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}