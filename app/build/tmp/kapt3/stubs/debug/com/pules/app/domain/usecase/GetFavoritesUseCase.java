package com.pules.app.domain.usecase;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/pules/app/domain/usecase/GetFavoritesUseCase;", "", "favoriteRepository", "Lcom/pules/app/data/repository/interfaces/FavoriteRepository;", "<init>", "(Lcom/pules/app/data/repository/interfaces/FavoriteRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pules/app/domain/model/Favorite;", "app_debug"})
public final class GetFavoritesUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.data.repository.interfaces.FavoriteRepository favoriteRepository = null;
    
    @javax.inject.Inject()
    public GetFavoritesUseCase(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.repository.interfaces.FavoriteRepository favoriteRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pules.app.domain.model.Favorite>> invoke() {
        return null;
    }
}