package com.pules.app.presentation.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.pules.app.domain.usecase.settings.GetSettingsUseCase
import com.pules.app.domain.usecase.settings.UpdateSettingsUseCase
import com.pules.app.workers.BackupWorker
import com.pules.app.workers.NotificationWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getSettingsUseCase: GetSettingsUseCase,
    private val updateSettingsUseCase: UpdateSettingsUseCase,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _themePreference = MutableStateFlow("system_default")
    val themePreference: StateFlow<String> = _themePreference.asStateFlow()

    private val _languagePreference = MutableStateFlow("en")
    val languagePreference: StateFlow<String> = _languagePreference.asStateFlow()

    private val _notificationPreference = MutableStateFlow(true)
    val notificationPreference: StateFlow<Boolean> = _notificationPreference.asStateFlow()

    private val _notificationFrequency = MutableStateFlow("daily") // e.g., "daily", "hourly", "never"
    val notificationFrequency: StateFlow<String> = _notificationFrequency.asStateFlow()

    private val _preferredSourcesForNotifications = MutableStateFlow<List<String>>(emptyList())
    val preferredSourcesForNotifications: StateFlow<List<String>> = _preferredSourcesForNotifications.asStateFlow()

    private val _apiKeys = MutableStateFlow<Map<String, String?>>(emptyMap())
    val apiKeys: StateFlow<Map<String, String?>> = _apiKeys.asStateFlow()

    // App Lock States
    private val _appLockEnabled = MutableStateFlow(false)
    val appLockEnabled: StateFlow<Boolean> = _appLockEnabled.asStateFlow()

    private val _appLockType = MutableStateFlow("none")
    val appLockType: StateFlow<String> = _appLockType.asStateFlow()

    private val _appLockValue = MutableStateFlow<String?>(null)
    val appLockValue: StateFlow<String?> = _appLockValue.asStateFlow()

    fun getApiKey(service: String): StateFlow<String?> {
        val flow = MutableStateFlow<String?>(null)
        viewModelScope.launch {
            getSettingsUseCase.getApiKey(service).collect { flow.value = it }
        }
        return flow
    }

    fun saveFacebookApiKey(key: String) = saveApiKey("facebook", key)
    fun saveInstagramApiKey(key: String) = saveApiKey("instagram", key)
    fun saveTikTokApiKey(key: String) = saveApiKey("tiktok", key)


    private val _autoBackupEnabled = MutableStateFlow(false)
    val autoBackupEnabled: StateFlow<Boolean> = _autoBackupEnabled.asStateFlow()

    private val _highContrastMode = MutableStateFlow(false)
    val highContrastMode: StateFlow<Boolean> = _highContrastMode.asStateFlow()

    private val _speechRate = MutableStateFlow(1.0f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    init {
        viewModelScope.launch {
            getSettingsUseCase.getThemePreference().collect { _themePreference.value = it }
        }
        viewModelScope.launch {
            getSettingsUseCase.getLanguagePreference().collect { _languagePreference.value = it }
        }
        viewModelScope.launch {
            getSettingsUseCase.getNotificationPreference().collect { enabled ->
                _notificationPreference.value = enabled
                if (enabled) {
                    scheduleNotifications()
                } else {
                    cancelNotifications()
                }
            }
        }
        viewModelScope.launch {
            getSettingsUseCase.getNotificationFrequency().collect { _notificationFrequency.value = it }
        }
        viewModelScope.launch {
            getSettingsUseCase.getPreferredSourcesForNotifications().collect { _preferredSourcesForNotifications.value = it }
        }
        // API keys are now fetched individually via getApiKey(service) function
        // No need to collect all of them here in init block
        viewModelScope.launch {
            getSettingsUseCase.getAutoBackupEnabled().collect { enabled ->
                _autoBackupEnabled.value = enabled
                if (enabled) {
                    scheduleAutoBackup()
                } else {
                    cancelAutoBackup()
                }
            }
            getSettingsUseCase.getHighContrastMode().collect { _highContrastMode.value = it }
            getSettingsUseCase.getSpeechRate().collect { _speechRate.value = it }
        }
        // Initialize App Lock settings
        viewModelScope.launch {
            getSettingsUseCase.getAppLockEnabled().collect { _appLockEnabled.value = it }
        }
        viewModelScope.launch {
            getSettingsUseCase.getAppLockType().collect { _appLockType.value = it }
        }
        viewModelScope.launch {
            getSettingsUseCase.getAppLockValue().collect { _appLockValue.value = it }
        }
    }

    fun saveThemePreference(theme: String) {
        viewModelScope.launch {
            updateSettingsUseCase.saveThemePreference(theme)
        }
    }

    fun saveLanguagePreference(language: String) {
        viewModelScope.launch {
            updateSettingsUseCase.saveLanguagePreference(language)
        }
    }

    fun saveNotificationPreference(enabled: Boolean) {
        viewModelScope.launch {
            updateSettingsUseCase.saveNotificationPreference(enabled)
        }
    }

    fun saveApiKey(service: String, key: String) {
        viewModelScope.launch {
            val isValid = validateApiKey(service, key)
            if (isValid) {
                updateSettingsUseCase.saveApiKey(service, key)
                println("API Key for $service is valid and saved!")
                // Optionally, update UI state to show success message
            } else {
                println("API Key for $service is invalid and not saved!")
                // Optionally, update UI state to show error message
            }
        }
    }

    private fun validateApiKey(service: String, key: String): Boolean {
        return when (service) {
            "facebook" -> key.startsWith("EA") && key.length > 30 // Example validation for Facebook
            "instagram" -> key.length > 20 && key.contains("IG") // Example validation for Instagram
            "tiktok" -> key.length > 25 && key.matches(Regex("^[a-zA-Z0-9_-]+")) // Example validation for TikTok
            else -> key.isNotBlank() && key.length > 10 // Generic validation
        }
    }

    fun saveAutoBackupEnabled(enabled: Boolean) {
        viewModelScope.launch {
            updateSettingsUseCase.saveAutoBackupEnabled(enabled)
        }
    }

    // App Lock functions
    fun saveAppLockEnabled(enabled: Boolean) {
        viewModelScope.launch {
            updateSettingsUseCase.saveAppLockEnabled(enabled)
        }
    }

    fun saveAppLockType(type: String) {
        viewModelScope.launch {
            updateSettingsUseCase.saveAppLockType(type)
        }
    }

    fun saveAppLockValue(value: String) {
        viewModelScope.launch {
            updateSettingsUseCase.saveAppLockValue(value)
        }
    }

    private fun scheduleNotifications() {
        val notificationWorkRequest = PeriodicWorkRequestBuilder<NotificationWorker>(15, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "PulesNotificationWork",
            ExistingPeriodicWorkPolicy.UPDATE,
            notificationWorkRequest
        )
    }

    private fun cancelNotifications() {
        WorkManager.getInstance(context).cancelUniqueWork("PulesNotificationWork")
    }

    private fun scheduleAutoBackup() {
        val backupWorkRequest = PeriodicWorkRequestBuilder<BackupWorker>(1, TimeUnit.DAYS)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "PulesAutoBackupWork",
            ExistingPeriodicWorkPolicy.UPDATE,
            backupWorkRequest
        )
    }

    private fun cancelAutoBackup() {
        WorkManager.getInstance(context).cancelUniqueWork("PulesAutoBackupWork")
    }

    fun triggerOneTimeBackup() {
        // Implement one-time backup logic here, perhaps using a OneTimeWorkRequest
        // For now, just log a message
        println("Triggering one-time backup!")
    }

    fun saveSpeechRate(rate: Float) {
        viewModelScope.launch {
            updateSettingsUseCase.saveSpeechRate(rate)
        }
    }
}


