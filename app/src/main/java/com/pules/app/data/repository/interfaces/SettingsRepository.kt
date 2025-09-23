package com.pules.app.data.repository.interfaces

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getThemePreference(): Flow<String>
    suspend fun saveThemePreference(theme: String)
    fun getLanguagePreference(): Flow<String>
    suspend fun saveLanguagePreference(language: String)
    fun getNotificationPreference(): Flow<Boolean>
    suspend fun saveNotificationPreference(enabled: Boolean)
    fun getApiKey(service: String): Flow<String?>
    suspend fun saveApiKey(service: String, key: String)
    fun getAutoBackupEnabled(): Flow<Boolean>
    suspend fun saveAutoBackupEnabled(enabled: Boolean)
    fun getNotificationFrequency(): Flow<String>
    suspend fun saveNotificationFrequency(frequency: String)
    fun getPreferredSourcesForNotifications(): Flow<List<String>>
    suspend fun savePreferredSourcesForNotifications(sources: List<String>)
    fun getFilterByTime(): Flow<String>
    suspend fun saveFilterByTime(time: String)
    fun getFilterByCategory(): Flow<String>
    suspend fun saveFilterByCategory(category: String)
    fun getFilterByLength(): Flow<String>
    suspend fun saveFilterByLength(length: String)
    fun getHighContrastMode(): Flow<Boolean>
    suspend fun saveHighContrastMode(enabled: Boolean)
    fun getSpeechRate(): Flow<Float>
    suspend fun saveSpeechRate(rate: Float)

    // App Lock settings
    fun getAppLockEnabled(): Flow<Boolean>
    suspend fun saveAppLockEnabled(enabled: Boolean)
    fun getAppLockType(): Flow<String>
    suspend fun saveAppLockType(type: String)
    fun getAppLockValue(): Flow<String?>
    suspend fun saveAppLockValue(value: String)
}


