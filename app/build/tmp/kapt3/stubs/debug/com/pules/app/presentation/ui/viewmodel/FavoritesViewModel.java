package com.pules.app.presentation.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/pules/app/presentation/ui/viewmodel/FavoritesViewModel;", "Landroidx/lifecycle/ViewModel;", "getFavoritesUseCase", "Lcom/pules/app/domain/usecase/GetFavoritesUseCase;", "addFavoriteUseCase", "Lcom/pules/app/domain/usecase/AddFavoriteUseCase;", "removeFavoriteUseCase", "Lcom/pules/app/domain/usecase/RemoveFavoriteUseCase;", "<init>", "(Lcom/pules/app/domain/usecase/GetFavoritesUseCase;Lcom/pules/app/domain/usecase/AddFavoriteUseCase;Lcom/pules/app/domain/usecase/RemoveFavoriteUseCase;)V", "_favorites", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/pules/app/domain/model/Favorite;", "favorites", "Lkotlinx/coroutines/flow/StateFlow;", "getFavorites", "()Lkotlinx/coroutines/flow/StateFlow;", "addFavorite", "", "favorite", "removeFavorite", "favoriteId", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FavoritesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.GetFavoritesUseCase getFavoritesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.AddFavoriteUseCase addFavoriteUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.RemoveFavoriteUseCase removeFavoriteUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.pules.app.domain.model.Favorite>> _favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pules.app.domain.model.Favorite>> favorites = null;
    
    @javax.inject.Inject()
    public FavoritesViewModel(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.GetFavoritesUseCase getFavoritesUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.AddFavoriteUseCase addFavoriteUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.RemoveFavoriteUseCase removeFavoriteUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.pules.app.domain.model.Favorite>> getFavorites() {
        return null;
    }
    
    public final void addFavorite(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.model.Favorite favorite) {
    }
    
    public final void removeFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String favoriteId) {
    }
}