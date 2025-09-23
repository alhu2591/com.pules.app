package com.pules.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.domain.model.Article
import com.pules.app.domain.model.Source
import com.pules.app.domain.usecase.GetArticlesUseCase
import com.pules.app.domain.usecase.GetSourcesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSourcesUseCase: GetSourcesUseCase,
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Any>>(emptyList())
    val searchResults: StateFlow<List<Any>> = _searchResults.asStateFlow()

    init {
        @OptIn(FlowPreview::class)
        searchQuery
            .debounce(300L) // Debounce to avoid excessive searches
            .onEach { query ->
                if (query.isNotBlank()) {
                    performSearch(query)
                } else {
                    _searchResults.value = emptyList()
                }
            }
            .launchIn(viewModelScope)
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            val lowerCaseQuery = query.lowercase()

            // Search sources
            val sources = getSourcesUseCase().firstOrNull()?.filter {
                it.name.lowercase().contains(lowerCaseQuery)
            } ?: emptyList()

            // Search articles (assuming articles have title and content)
            val articles = getArticlesUseCase().firstOrNull()?.filter {
                it.title.lowercase().contains(lowerCaseQuery) ||
                it.content.lowercase().contains(lowerCaseQuery)
            } ?: emptyList()

            // Combine results (you might want to categorize them later)
            _searchResults.value = sources + articles
        }
    }
}


