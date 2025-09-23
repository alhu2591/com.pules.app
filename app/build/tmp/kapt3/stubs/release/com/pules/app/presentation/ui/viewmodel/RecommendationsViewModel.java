package com.pules.app.presentation.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/pules/app/presentation/ui/viewmodel/RecommendationsViewModel;", "Landroidx/lifecycle/ViewModel;", "getFavoritesUseCase", "Lcom/pules/app/domain/usecase/GetFavoritesUseCase;", "getReadLaterItemsUseCase", "Lcom/pules/app/domain/usecase/GetReadLaterItemsUseCase;", "<init>", "(Lcom/pules/app/domain/usecase/GetFavoritesUseCase;Lcom/pules/app/domain/usecase/GetReadLaterItemsUseCase;)V", "_recommendedArticles", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "recommendedArticles", "Lkotlinx/coroutines/flow/StateFlow;", "getRecommendedArticles", "()Lkotlinx/coroutines/flow/StateFlow;", "generateRecommendations", "favorites", "Lcom/pules/app/domain/model/Favorite;", "readLaterItems", "Lcom/pules/app/domain/model/ReadLaterItem;", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RecommendationsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetFavoritesUseCase getFavoritesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetReadLaterItemsUseCase getReadLaterItemsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _recommendedArticles = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> recommendedArticles = null;
    
    @javax.inject.Inject()
    public RecommendationsViewModel(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetFavoritesUseCase getFavoritesUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetReadLaterItemsUseCase getReadLaterItemsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getRecommendedArticles() {
        return null;
    }
    
    private final java.util.List<java.lang.String> generateRecommendations(java.util.List<com.pules.app.domain.model.Favorite> favorites, java.util.List<com.pules.app.domain.model.ReadLaterItem> readLaterItems) {
        return null;
    }
}