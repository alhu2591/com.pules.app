package com.pules.app.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pules.app.data.repository.SettingsRepository
import com.pules.app.domain.usecase.BackupRestoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository,
    val backupRestoreUseCase: BackupRestoreUseCase
) : ViewModel() {

    private val _backupRestoreMessage = MutableStateFlow<String?>(null)
    val backupRestoreMessage: StateFlow<String?> = _backupRestoreMessage.asStateFlow()

    val appTheme: StateFlow<String> = settingsRepository.appTheme
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "system")

    val fontSize: StateFlow<String> = settingsRepository.fontSize
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "medium")

    val primaryColor: StateFlow<String> = settingsRepository.primaryColor
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "default")

    val appLanguage: StateFlow<String> = settingsRepository.appLanguage
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "system")

    val notificationsEnabled: StateFlow<Boolean> = settingsRepository.notificationsEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    val notificationType: StateFlow<String> = settingsRepository.notificationType
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "simple")

    val notificationSchedule: StateFlow<String> = settingsRepository.notificationSchedule
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "6h")

    val youtubeApiKey: StateFlow<String?> = settingsRepository.youtubeApiKey
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val twitterBearerToken: StateFlow<String?> = settingsRepository.twitterBearerToken
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val analyticsEnabled: StateFlow<Boolean> = settingsRepository.analyticsEnabled
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    fun setAppTheme(theme: String) {
        viewModelScope.launch { settingsRepository.setAppTheme(theme) }
    }

    fun setFontSize(size: String) {
        viewModelScope.launch { settingsRepository.setFontSize(size) }
    }

    fun setPrimaryColor(color: String) {
        viewModelScope.launch { settingsRepository.setPrimaryColor(color) }
    }

    fun setAppLanguage(language: String) {
        viewModelScope.launch { settingsRepository.setAppLanguage(language) }
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        viewModelScope.launch { settingsRepository.setNotificationsEnabled(enabled) }
    }

    fun setNotificationType(type: String) {
        viewModelScope.launch { settingsRepository.setNotificationType(type) }
    }

    fun setNotificationSchedule(schedule: String) {
        viewModelScope.launch { settingsRepository.setNotificationSchedule(schedule) }
    }

    fun setYoutubeApiKey(key: String) {
        viewModelScope.launch { settingsRepository.setYoutubeApiKey(key) }
    }

    fun setTwitterBearerToken(token: String) {
        viewModelScope.launch { settingsRepository.setTwitterBearerToken(token) }
    }

    fun setAnalyticsEnabled(enabled: Boolean) {
        viewModelScope.launch { settingsRepository.setAnalyticsEnabled(enabled) }
    }

    fun createBackup(uri: Uri) {
        viewModelScope.launch {
            _backupRestoreMessage.value = "Creating backup..."
            backupRestoreUseCase.createBackup(uri)
                .onSuccess { _backupRestoreMessage.value = "Backup created successfully!" }
                .onFailure { _backupRestoreMessage.value = "Backup failed: ${it.message}" }
        }
    }

    fun restoreBackup(uri: Uri) {
        viewModelScope.launch {
            _backupRestoreMessage.value = "Restoring backup..."
            backupRestoreUseCase.restoreBackup(uri)
                .onSuccess { _backupRestoreMessage.value = "Backup restored successfully!" }
                .onFailure { _backupRestoreMessage.value = "Restore failed: ${it.message}" }
        }
    }

    fun clearBackupRestoreMessage() {
        _backupRestoreMessage.value = null
    }
}


