package com.pules.app.domain.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086B\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/pules/app/domain/usecase/RestoreBackupUseCase;", "", "backupRepository", "Lcom/pules/app/data/repository/interfaces/BackupRepository;", "<init>", "(Lcom/pules/app/data/repository/interfaces/BackupRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "backupData", "Lcom/pules/app/data/model/BackupData;", "(Lcom/pules/app/data/model/BackupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RestoreBackupUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.data.repository.interfaces.BackupRepository backupRepository = null;
    
    @javax.inject.Inject()
    public RestoreBackupUseCase(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.repository.interfaces.BackupRepository backupRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.model.BackupData backupData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<kotlin.Unit>> $completion) {
        return null;
    }
}