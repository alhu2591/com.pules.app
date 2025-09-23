package com.pules.app.workers;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B-\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/pules/app/workers/DailyDigestWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "getSourcesUseCase", "Lcom/pules/app/domain/usecase/GetSourcesUseCase;", "getRecommendedArticlesUseCase", "error/NonExistentClass", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/pules/app/domain/usecase/GetSourcesUseCase;Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "app_release"})
public final class DailyDigestWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkerParameters workerParams = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetSourcesUseCase getSourcesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass getRecommendedArticlesUseCase = null;
    
    @dagger.assisted.AssistedInject()
    public DailyDigestWorker(@dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetSourcesUseCase getSourcesUseCase, @org.jetbrains.annotations.NotNull()
    error.NonExistentClass getRecommendedArticlesUseCase) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    @error.NonExistentClass()
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b\u00c0\u0006\u0003"}, d2 = {"Lcom/pules/app/workers/DailyDigestWorker$Factory;", "", "create", "Lcom/pules/app/workers/DailyDigestWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "app_release"})
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.pules.app.workers.DailyDigestWorker create(@org.jetbrains.annotations.NotNull()
        android.content.Context appContext, @org.jetbrains.annotations.NotNull()
        androidx.work.WorkerParameters workerParams);
    }
}