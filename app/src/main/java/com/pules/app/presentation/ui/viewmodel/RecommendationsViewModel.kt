package com.pules.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.domain.model.Favorite
import com.pules.app.domain.model.ReadLaterItem
import com.pules.app.domain.usecase.GetFavoritesUseCase
import com.pules.app.domain.usecase.GetReadLaterItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendationsViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val getReadLaterItemsUseCase: GetReadLaterItemsUseCase
) : ViewModel() {

    private val _recommendedArticles = MutableStateFlow<List<String>>(emptyList())
    val recommendedArticles: StateFlow<List<String>> = _recommendedArticles.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                getFavoritesUseCase.execute(),
                getReadLaterItemsUseCase.execute()
            ) { favorites, readLaterItems ->
                generateRecommendations(favorites, readLaterItems)
            }.collect { recommendations ->
                _recommendedArticles.value = recommendations
            }
        }
    }

    private fun generateRecommendations(favorites: List<Favorite>, readLaterItems: List<ReadLaterItem>): List<String> {
        // More sophisticated recommendation logic:
        // 1. Extract keywords/categories from favorites and read later items.
        // 2. Count frequency of keywords/categories.
        // 3. Use these to suggest articles that match popular themes.

        val allKeywords = mutableListOf<String>()

        // Assuming Favorite and ReadLaterItem have a 'category' or 'keywords' field
        // For now, we'll just use titles and split them into words as a proxy for keywords
        (favorites.map { it.title } + readLaterItems.map { it.title }).forEach { title ->
            allKeywords.addAll(title.split(" ").map { it.lowercase().trim() })
        }

        val keywordCounts = allKeywords.groupingBy { it }.eachCount()

        // Filter out common words and single-letter words
        val significantKeywords = keywordCounts.filter { (word, count) ->
            word.length > 2 && count > 1 && word !in listOf("the", "and", "a", "an", "in", "of", "for", "with", "on", "is", "to", "from")
        }.keys.toList()

        // For now, we'll just return a combination of popular keywords as recommendations.
        // In a real app, this would involve fetching actual articles based on these keywords.
        return significantKeywords.shuffled().take(5).map { "Recommended: $it" }
    }
}


