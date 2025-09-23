package com.pules.app.presentation.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/pules/app/presentation/ui/viewmodel/ReadLaterViewModel;", "Landroidx/lifecycle/ViewModel;", "getReadLaterItemsUseCase", "Lcom/pules/app/domain/usecase/GetReadLaterItemsUseCase;", "addReadLaterItemUseCase", "Lcom/pules/app/domain/usecase/AddReadLaterItemUseCase;", "removeReadLaterItemUseCase", "Lcom/pules/app/domain/usecase/RemoveReadLaterItemUseCase;", "getArticleContentUseCase", "Lcom/pules/app/domain/usecase/GetArticleContentUseCase;", "getReadLaterItemContentUseCase", "Lcom/pules/app/domain/usecase/GetReadLaterItemContentUseCase;", "<init>", "(Lcom/pules/app/domain/usecase/GetReadLaterItemsUseCase;Lcom/pules/app/domain/usecase/AddReadLaterItemUseCase;Lcom/pules/app/domain/usecase/RemoveReadLaterItemUseCase;Lcom/pules/app/domain/usecase/GetArticleContentUseCase;Lcom/pules/app/domain/usecase/GetReadLaterItemContentUseCase;)V", "_readLaterItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/pules/app/domain/model/ReadLaterItem;", "readLaterItems", "Lkotlinx/coroutines/flow/StateFlow;", "getReadLaterItems", "()Lkotlinx/coroutines/flow/StateFlow;", "addReadLaterItem", "", "item", "removeReadLaterItem", "itemId", "", "getOfflineArticleContent", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ReadLaterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetReadLaterItemsUseCase getReadLaterItemsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.AddReadLaterItemUseCase addReadLaterItemUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.RemoveReadLaterItemUseCase removeReadLaterItemUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetArticleContentUseCase getArticleContentUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetReadLaterItemContentUseCase getReadLaterItemContentUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.pules.app.domain.model.ReadLaterItem>> _readLaterItems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pules.app.domain.model.ReadLaterItem>> readLaterItems = null;
    
    @javax.inject.Inject()
    public ReadLaterViewModel(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetReadLaterItemsUseCase getReadLaterItemsUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.AddReadLaterItemUseCase addReadLaterItemUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.RemoveReadLaterItemUseCase removeReadLaterItemUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetArticleContentUseCase getArticleContentUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetReadLaterItemContentUseCase getReadLaterItemContentUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pules.app.domain.model.ReadLaterItem>> getReadLaterItems() {
        return null;
    }
    
    public final void addReadLaterItem(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.model.ReadLaterItem item) {
    }
    
    public final void removeReadLaterItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOfflineArticleContent(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}