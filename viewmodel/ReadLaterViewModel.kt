package com.pules.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.data.repository.ReadLaterRepository
import com.pules.app.domain.model.ContentItem
import com.pules.app.domain.model.SourceType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReadLaterViewModel @Inject constructor(
    private val readLaterRepository: ReadLaterRepository
) : ViewModel() {

    private val _readLaterItems = MutableStateFlow<List<ContentItem>>(emptyList())
    val readLaterItems: StateFlow<List<ContentItem>> = _readLaterItems.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadReadLaterItems()
    }

    fun loadReadLaterItems() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            readLaterRepository.getAllReadLaterItems().collect {
                _readLaterItems.value = it.map { entity -> entity.toDomainModel() }
                _isLoading.value = false
            }
        }
    }

    fun removeReadLaterItem(itemId: Int) {
        viewModelScope.launch {
            try {
                readLaterRepository.removeReadLaterItem(itemId)
            } catch (e: Exception) {
                _error.value = "Failed to remove item: ${e.message}"
            }
        }
    }

    private fun com.pules.app.data.local.database.entities.ReadLaterEntity.toDomainModel(): ContentItem {
        return ContentItem(
            id = this.contentId,
            title = this.title,
            description = null,
            thumbnailUrl = this.thumbnailUrl,
            contentUrl = this.contentUrl,
            publishedAt = this.savedDate,
            sourceType = SourceType.valueOf(this.sourceType.uppercase()),
            sourceName = "",
            sourceImageUrl = null
        )
    }
}


