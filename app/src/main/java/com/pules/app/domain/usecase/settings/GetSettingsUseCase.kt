package com.pules.app.domain.usecase.settings

import com.pules.app.data.repository.interfaces.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSettingsUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    fun getThemePreference(): Flow<String> = settingsRepository.getThemePreference()
    fun getLanguagePreference(): Flow<String> = settingsRepository.getLanguagePreference()
    fun getNotificationPreference(): Flow<Boolean> = settingsRepository.getNotificationPreference()
    fun getApiKey(service: String): Flow<String?> = settingsRepository.getApiKey(service)
    fun getAutoBackupEnabled(): Flow<Boolean> = settingsRepository.getAutoBackupEnabled()
    fun getNotificationFrequency(): Flow<String> = settingsRepository.getNotificationFrequency()
    fun getPreferredSourcesForNotifications(): Flow<List<String>> = settingsRepository.getPreferredSourcesForNotifications()
    fun getFilterByTime(): Flow<String> = settingsRepository.getFilterByTime()
    fun getFilterByCategory(): Flow<String> = settingsRepository.getFilterByCategory()
    fun getFilterByLength(): Flow<String> = settingsRepository.getFilterByLength()
    fun getHighContrastMode(): Flow<Boolean> = settingsRepository.getHighContrastMode()
    fun getSpeechRate(): Flow<Float> = settingsRepository.getSpeechRate()

    // App Lock settings
    fun getAppLockEnabled(): Flow<Boolean> = settingsRepository.getAppLockEnabled()
    fun getAppLockType(): Flow<String> = settingsRepository.getAppLockType()
    fun getAppLockValue(): Flow<String?> = settingsRepository.getAppLockValue()
}


