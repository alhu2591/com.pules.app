package com.pules.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.domain.model.ReadLaterItem
import com.pules.app.domain.usecase.AddReadLaterItemUseCase
import com.pules.app.domain.usecase.GetArticleContentUseCase
import com.pules.app.domain.usecase.GetReadLaterItemContentUseCase
import com.pules.app.domain.usecase.GetReadLaterItemsUseCase
import com.pules.app.domain.usecase.RemoveReadLaterItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReadLaterViewModel @Inject constructor(
    private val getReadLaterItemsUseCase: GetReadLaterItemsUseCase,
    private val addReadLaterItemUseCase: AddReadLaterItemUseCase,
    private val removeReadLaterItemUseCase: RemoveReadLaterItemUseCase,
    private val getArticleContentUseCase: GetArticleContentUseCase,
    private val getReadLaterItemContentUseCase: GetReadLaterItemContentUseCase
) : ViewModel() {

    private val _readLaterItems = MutableStateFlow<List<ReadLaterItem>>(emptyList())
    val readLaterItems: StateFlow<List<ReadLaterItem>> = _readLaterItems

    init {
        viewModelScope.launch {
            getReadLaterItemsUseCase().collect {
                _readLaterItems.value = it
            }
        }
    }

    fun addReadLaterItem(item: ReadLaterItem) {
        viewModelScope.launch {
            // Fetch article content for offline reading before saving
            val content = getArticleContentUseCase(item.url)
            addReadLaterItemUseCase(item.copy(content = content))
        }
    }

    fun removeReadLaterItem(itemId: String) {
        viewModelScope.launch {
            removeReadLaterItemUseCase(itemId)
        }
    }

    suspend fun getOfflineArticleContent(itemId: String): String? {
        return getReadLaterItemContentUseCase(itemId)
    }
}


