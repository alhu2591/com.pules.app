package com.pules.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.data.repository.FavoriteRepository
import com.pules.app.data.repository.SourceRepository
import com.pules.app.domain.model.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository,
    private val sourceRepository: SourceRepository
) : ViewModel() {

    private val _favoriteSources = MutableStateFlow<List<Source>>(emptyList())
    val favoriteSources: StateFlow<List<Source>> = _favoriteSources.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadFavoriteSources()
    }

    private fun loadFavoriteSources() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            favoriteRepository.getAllFavorites()
                .combine(sourceRepository.getAllSources()) { favorites, allSources ->
                    favorites.mapNotNull { favorite ->
                        allSources.find { it.id == favorite.sourceId }?.toDomainModel()
                    }
                }
                .collect {
                    _favoriteSources.value = it
                    _isLoading.value = false
                }
        }
    }

    fun removeFavorite(sourceId: Int) {
        viewModelScope.launch {
            try {
                favoriteRepository.removeFavorite(sourceId)
            } catch (e: Exception) {
                _error.value = "Failed to remove favorite: ${e.message}"
            }
        }
    }

    private fun com.pules.app.data.local.database.entities.SourceEntity.toDomainModel(): Source {
        return Source(
            id = this.id,
            name = this.name,
            url = this.url,
            type = com.pules.app.domain.model.SourceType.valueOf(this.type.uppercase()),
            imageUrl = this.imageUrl,
            followersCount = this.followersCount,
            lastContentDate = this.lastContentDate
        )
    }
}


