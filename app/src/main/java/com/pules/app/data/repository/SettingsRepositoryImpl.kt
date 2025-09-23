package com.pules.app.data.repository

import com.pules.app.data.local.SettingsDataStore
import com.pules.app.data.repository.interfaces.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val settingsDataStore: SettingsDataStore
) : SettingsRepository {
    override fun getThemePreference(): Flow<String> = settingsDataStore.getThemePreference()
    override suspend fun saveThemePreference(theme: String) = settingsDataStore.saveThemePreference(theme)
    override fun getLanguagePreference(): Flow<String> = settingsDataStore.getLanguagePreference()
    override suspend fun saveLanguagePreference(language: String) = settingsDataStore.saveLanguagePreference(language)
    override fun getNotificationPreference(): Flow<Boolean> = settingsDataStore.getNotificationPreference()
    override suspend fun saveNotificationPreference(enabled: Boolean) = settingsDataStore.saveNotificationPreference(enabled)
    override fun getApiKey(service: String): Flow<String?> = settingsDataStore.getApiKey(service)
    override suspend fun saveApiKey(service: String, key: String) = settingsDataStore.saveApiKey(service, key)
    override fun getAutoBackupEnabled(): Flow<Boolean> = settingsDataStore.getAutoBackupEnabled()
    override suspend fun saveAutoBackupEnabled(enabled: Boolean) = settingsDataStore.saveAutoBackupEnabled(enabled)
    override fun getNotificationFrequency(): Flow<String> = settingsDataStore.getNotificationFrequency()
    override suspend fun saveNotificationFrequency(frequency: String) = settingsDataStore.saveNotificationFrequency(frequency)
    override fun getPreferredSourcesForNotifications(): Flow<List<String>> = settingsDataStore.getPreferredSourcesForNotifications()
    override suspend fun savePreferredSourcesForNotifications(sources: List<String>) = settingsDataStore.savePreferredSourcesForNotifications(sources)
    override fun getFilterByTime(): Flow<String> = settingsDataStore.getFilterByTime()
    override suspend fun saveFilterByTime(time: String) = settingsDataStore.saveFilterByTime(time)
    override fun getFilterByCategory(): Flow<String> = settingsDataStore.getFilterByCategory()
    override suspend fun saveFilterByCategory(category: String) = settingsDataStore.saveFilterByCategory(category)
    override fun getFilterByLength(): Flow<String> = settingsDataStore.getFilterByLength()
    override suspend fun saveFilterByLength(length: String) = settingsDataStore.saveFilterByLength(length)
    override fun getHighContrastMode(): Flow<Boolean> = settingsDataStore.getHighContrastMode()
    override suspend fun saveHighContrastMode(enabled: Boolean) = settingsDataStore.saveHighContrastMode(enabled)
    override fun getSpeechRate(): Flow<Float> = settingsDataStore.getSpeechRate()
    override suspend fun saveSpeechRate(rate: Float) = settingsDataStore.saveSpeechRate(rate)

    override fun getAppLockEnabled(): Flow<Boolean> = settingsDataStore.getAppLockEnabled()
    override suspend fun saveAppLockEnabled(enabled: Boolean) = settingsDataStore.saveAppLockEnabled(enabled)
    override fun getAppLockType(): Flow<String> = settingsDataStore.getAppLockType()
    override suspend fun saveAppLockType(type: String) = settingsDataStore.saveAppLockType(type)
    override fun getAppLockValue(): Flow<String?> = settingsDataStore.getAppLockValue()
    override suspend fun saveAppLockValue(value: String) = settingsDataStore.saveAppLockValue(value)
}


