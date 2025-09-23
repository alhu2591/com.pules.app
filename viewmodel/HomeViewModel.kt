package com.pules.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.data.repository.SourceRepository
import com.pules.app.domain.model.ContentItem
import com.pules.app.domain.model.Source
import com.pules.app.domain.usecase.FetchContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sourceRepository: SourceRepository,
    private val fetchContentUseCase: FetchContentUseCase
) : ViewModel() {

    private val _contentItems = MutableStateFlow<List<ContentItem>>(emptyList())
    val contentItems: StateFlow<List<ContentItem>> = _contentItems.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadContent()
    }

    fun loadContent() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            sourceRepository.getAllSources().collect {
                val allContent = mutableListOf<ContentItem>()
                it.map { entity -> entity.toDomainModel() }.forEach { source ->
                    fetchContentUseCase(source)
                        .onSuccess { content ->
                            allContent.addAll(content)
                        }
                        .onFailure { e ->
                            _error.value = "Error fetching content for ${source.name}: ${e.message}"
                        }
                }
                _contentItems.value = allContent.sortedByDescending { it.publishedAt }
                _isLoading.value = false
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


