package com.pules.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.data.repository.SourceRepository
import com.pules.app.domain.model.Source
import com.pules.app.domain.usecase.AddSourceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val sourceRepository: SourceRepository,
    private val addSourceUseCase: AddSourceUseCase
) : ViewModel() {

    private val _sources = MutableStateFlow<List<Source>>(emptyList())
    val sources: StateFlow<List<List<Source>>> = _sources.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadSources()
    }

    fun loadSources() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            sourceRepository.getAllSources().collect {
                _sources.value = listOf(it.map { entity -> entity.toDomainModel() })
                _isLoading.value = false
            }
        }
    }

    fun addSource(url: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            addSourceUseCase(url).onSuccess {
                loadSources()
            }.onFailure {
                _error.value = it.message
            }
            _isLoading.value = false
        }
    }

    fun updateSource(source: Source) {
        viewModelScope.launch {
            try {
                sourceRepository.updateSource(source.toEntity())
                loadSources()
            } catch (e: Exception) {
                _error.value = "Failed to update source: ${e.message}"
            }
        }
    }

    fun deleteSource(sourceId: Int) {
        viewModelScope.launch {
            try {
                sourceRepository.deleteSource(sourceId)
                loadSources()
            } catch (e: Exception) {
                _error.value = "Failed to delete source: ${e.message}"
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

    private fun Source.toEntity(): com.pules.app.data.local.database.entities.SourceEntity {
        return com.pules.app.data.local.database.entities.SourceEntity(
            id = this.id,
            name = this.name,
            url = this.url,
            type = this.type.name.lowercase(),
            imageUrl = this.imageUrl,
            followersCount = this.followersCount,
            lastContentDate = this.lastContentDate
        )
    }
}


