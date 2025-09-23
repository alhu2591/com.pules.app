package com.pules.app.domain.usecase.settings

import com.pules.app.data.repository.interfaces.SettingsRepository
import javax.inject.Inject

class UpdateSettingsUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    suspend fun saveThemePreference(theme: String) = settingsRepository.saveThemePreference(theme)
    suspend fun saveLanguagePreference(language: String) = settingsRepository.saveLanguagePreference(language)
    suspend fun saveNotificationPreference(enabled: Boolean) = settingsRepository.saveNotificationPreference(enabled)
    suspend fun saveApiKey(service: String, key: String) = settingsRepository.saveApiKey(service, key)
    suspend fun saveAutoBackupEnabled(enabled: Boolean) = settingsRepository.saveAutoBackupEnabled(enabled)
    suspend fun saveNotificationFrequency(frequency: String) = settingsRepository.saveNotificationFrequency(frequency)
    suspend fun savePreferredSourcesForNotifications(sources: List<String>) = settingsRepository.savePreferredSourcesForNotifications(sources)
    suspend fun saveFilterByTime(time: String) = settingsRepository.saveFilterByTime(time)
    suspend fun saveFilterByCategory(category: String) = settingsRepository.saveFilterByCategory(category)
    suspend fun saveFilterByLength(length: String) = settingsRepository.saveFilterByLength(length)
    suspend fun saveHighContrastMode(enabled: Boolean) = settingsRepository.saveHighContrastMode(enabled)
    suspend fun saveSpeechRate(rate: Float) = settingsRepository.saveSpeechRate(rate)

    // App Lock settings
    suspend fun saveAppLockEnabled(enabled: Boolean) = settingsRepository.saveAppLockEnabled(enabled)
    suspend fun saveAppLockType(type: String) = settingsRepository.saveAppLockType(type)
    suspend fun saveAppLockValue(value: String) = settingsRepository.saveAppLockValue(value)
}


