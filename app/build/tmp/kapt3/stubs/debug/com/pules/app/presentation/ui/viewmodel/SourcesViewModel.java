package com.pules.app.presentation.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017J.\u0010\u001c\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001d2\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/pules/app/presentation/ui/viewmodel/SourcesViewModel;", "Landroidx/lifecycle/ViewModel;", "getSourcesUseCase", "Lcom/pules/app/domain/usecase/GetSourcesUseCase;", "addSourceUseCase", "Lcom/pules/app/domain/usecase/AddSourceUseCase;", "removeSourceUseCase", "Lcom/pules/app/domain/usecase/RemoveSourceUseCase;", "getSourceInfoUseCase", "Lcom/pules/app/domain/usecase/GetSourceInfoUseCase;", "<init>", "(Lcom/pules/app/domain/usecase/GetSourcesUseCase;Lcom/pules/app/domain/usecase/AddSourceUseCase;Lcom/pules/app/domain/usecase/RemoveSourceUseCase;Lcom/pules/app/domain/usecase/GetSourceInfoUseCase;)V", "_sources", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/pules/app/domain/model/Source;", "sources", "Lkotlinx/coroutines/flow/StateFlow;", "getSources", "()Lkotlinx/coroutines/flow/StateFlow;", "addSource", "", "name", "", "url", "category", "removeSource", "sourceId", "checkSourceUrl", "Lkotlin/Triple;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SourcesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetSourcesUseCase getSourcesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.AddSourceUseCase addSourceUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.RemoveSourceUseCase removeSourceUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetSourceInfoUseCase getSourceInfoUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.pules.app.domain.model.Source>> _sources = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pules.app.domain.model.Source>> sources = null;
    
    @javax.inject.Inject()
    public SourcesViewModel(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetSourcesUseCase getSourcesUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.AddSourceUseCase addSourceUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.RemoveSourceUseCase removeSourceUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetSourceInfoUseCase getSourceInfoUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pules.app.domain.model.Source>> getSources() {
        return null;
    }
    
    public final void addSource(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String category) {
    }
    
    public final void removeSource(@org.jetbrains.annotations.NotNull()
    java.lang.String sourceId) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkSourceUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Triple<java.lang.String, java.lang.String, java.lang.String>> $completion) {
        return null;
    }
}