package com.pules.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.domain.model.Source
import com.pules.app.domain.usecase.AddSourceUseCase
import com.pules.app.domain.usecase.GetSourcesUseCase
import com.pules.app.domain.usecase.RemoveSourceUseCase
import com.pules.app.domain.usecase.GetSourceInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val getSourcesUseCase: GetSourcesUseCase,
    private val addSourceUseCase: AddSourceUseCase,
    private val removeSourceUseCase: RemoveSourceUseCase,
    private val getSourceInfoUseCase: GetSourceInfoUseCase
) : ViewModel() {

    private val _sources = MutableStateFlow<List<Source>>(emptyList())
    val sources: StateFlow<List<Source>> = _sources

    init {
        viewModelScope.launch {
            getSourcesUseCase().collect {
                _sources.value = it
            }
        }
    }

    fun addSource(name: String, url: String, category: String?) {
        viewModelScope.launch {
            addSourceUseCase(Source(id = name, name = name, url = url, description = null, imageUrl = null, category = category, language = null, country = null, isFollowed = true))
        }
    }

    fun removeSource(sourceId: String) {
        viewModelScope.launch {
            removeSourceUseCase(sourceId)
        }
    }

    suspend fun checkSourceUrl(url: String): Triple<String?, String?, String?> {
        return getSourceInfoUseCase(url)
    }
}


