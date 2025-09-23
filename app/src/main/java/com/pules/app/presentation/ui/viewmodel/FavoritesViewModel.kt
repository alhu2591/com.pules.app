package com.pules.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.domain.model.Favorite
import com.pules.app.domain.usecase.AddFavoriteUseCase
import com.pules.app.domain.usecase.GetFavoritesUseCase
import com.pules.app.domain.usecase.RemoveFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : ViewModel() {

    private val _favorites = MutableStateFlow<List<Favorite>>(emptyList())
    val favorites: StateFlow<List<Favorite>> = _favorites

    init {
        viewModelScope.launch {
            getFavoritesUseCase().collect {
                _favorites.value = it
            }
        }
    }

    fun addFavorite(favorite: Favorite) {
        viewModelScope.launch {
            addFavoriteUseCase(favorite)
        }
    }

    fun removeFavorite(favoriteId: String) {
        viewModelScope.launch {
            removeFavoriteUseCase(favoriteId)
        }
    }
}


