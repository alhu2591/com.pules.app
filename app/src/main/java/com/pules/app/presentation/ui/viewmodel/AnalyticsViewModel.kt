package com.pules.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.domain.usecase.GetFavoritesUseCase
import com.pules.app.domain.usecase.GetReadLaterItemsUseCase
import com.pules.app.domain.usecase.GetSourcesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val getReadLaterItemsUseCase: GetReadLaterItemsUseCase,
    private val getSourcesUseCase: GetSourcesUseCase
) : ViewModel() {

    private val _totalFavorites = MutableStateFlow(0)
    val totalFavorites: StateFlow<Int> = _totalFavorites.asStateFlow()

    private val _totalReadLaterItems = MutableStateFlow(0)
    val totalReadLaterItems: StateFlow<Int> = _totalReadLaterItems.asStateFlow()

    private val _totalSources = MutableStateFlow(0)
    val totalSources: StateFlow<Int> = _totalSources.asStateFlow()

    private val _favoriteCategories = MutableStateFlow<Map<String, Int>>(emptyMap())
    val favoriteCategories: StateFlow<Map<String, Int>> = _favoriteCategories.asStateFlow()

    init {
        viewModelScope.launch {
            getFavoritesUseCase.execute().collect { favorites ->
                _totalFavorites.value = favorites.size
                _favoriteCategories.value = favorites.groupingBy { it.sourceId }.eachCount()
            }
        }
        viewModelScope.launch {
            getReadLaterItemsUseCase.execute().collect { readLaterItems ->
                _totalReadLaterItems.value = readLaterItems.size
            }
        }
        viewModelScope.launch {
            getSourcesUseCase.execute().collect { sources ->
                _totalSources.value = sources.size
            }
        }
    }
}


