package com.pules.app.data.local.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataStore by preferencesDataStore(name = "settings")

@Singleton
class SettingsDataStore @Inject constructor(@ApplicationContext private val context: Context) {

    private val THEME_PREFERENCE_KEY = stringPreferencesKey("theme_preference")
    private val LANGUAGE_PREFERENCE_KEY = stringPreferencesKey("language_preference")
    private val NOTIFICATION_PREFERENCE_KEY = booleanPreferencesKey("notification_preference")
    private val ONBOARDING_COMPLETED_KEY = booleanPreferencesKey("onboarding_completed")
    private val AUTO_BACKUP_ENABLED_KEY = booleanPreferencesKey("auto_backup_enabled")
    private val NOTIFICATION_FREQUENCY_KEY = stringPreferencesKey("notification_frequency")
    private val PREFERRED_SOURCES_FOR_NOTIFICATIONS_KEY = stringPreferencesKey("preferred_sources_for_notifications")
    private val FILTER_BY_TIME_KEY = stringPreferencesKey("filter_by_time")
    private val FILTER_BY_CATEGORY_KEY = stringPreferencesKey("filter_by_category")
    private val FILTER_BY_LENGTH_KEY = stringPreferencesKey("filter_by_length")
    private val HIGH_CONTRAST_MODE_KEY = booleanPreferencesKey("high_contrast_mode")
    private val SPEECH_RATE_KEY = floatPreferencesKey("speech_rate")

    // App Lock Preferences
    private val APP_LOCK_ENABLED_KEY = booleanPreferencesKey("app_lock_enabled")
    private val APP_LOCK_TYPE_KEY = stringPreferencesKey("app_lock_type") // "none", "fingerprint", "pin", "password"
    private val APP_LOCK_VALUE_KEY = stringPreferencesKey("app_lock_value") // Stores PIN or password

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        "secret_shared_prefs",
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun getThemePreference(): Flow<String> {
        return context.dataStore.data.map {
            it[THEME_PREFERENCE_KEY] ?: "system_default"
        }
    }

    suspend fun saveThemePreference(theme: String) {
        context.dataStore.edit {
            it[THEME_PREFERENCE_KEY] = theme
        }
    }

    fun getLanguagePreference(): Flow<String> {
        return context.dataStore.data.map {
            it[LANGUAGE_PREFERENCE_KEY] ?: "en"
        }
    }

    suspend fun saveLanguagePreference(language: String) {
        context.dataStore.edit {
            it[LANGUAGE_PREFERENCE_KEY] = language
        }
    }

    fun getNotificationPreference(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[NOTIFICATION_PREFERENCE_KEY] ?: true
        }
    }

    suspend fun saveNotificationPreference(enabled: Boolean) {
        context.dataStore.edit {
            it[NOTIFICATION_PREFERENCE_KEY] = enabled
        }
    }

    fun getApiKey(service: String): Flow<String?> {
        return context.dataStore.data.map {
            encryptedSharedPreferences.getString(service, null)
        }
    }

    suspend fun saveApiKey(service: String, key: String) {
        encryptedSharedPreferences.edit().putString(service, key).apply()
    }

    fun isOnboardingCompleted(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[ONBOARDING_COMPLETED_KEY] ?: false
        }
    }

    suspend fun saveOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit {
            it[ONBOARDING_COMPLETED_KEY] = completed
        }
    }

    fun getAutoBackupEnabled(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[AUTO_BACKUP_ENABLED_KEY] ?: false
        }
    }

    suspend fun saveAutoBackupEnabled(enabled: Boolean) {
        context.dataStore.edit {
            it[AUTO_BACKUP_ENABLED_KEY] = enabled
        }
    }

    fun getNotificationFrequency(): Flow<String> {
        return context.dataStore.data.map {
            it[NOTIFICATION_FREQUENCY_KEY] ?: "daily"
        }
    }

    suspend fun saveNotificationFrequency(frequency: String) {
        context.dataStore.edit {
            it[NOTIFICATION_FREQUENCY_KEY] = frequency
        }
    }

    fun getPreferredSourcesForNotifications(): Flow<List<String>> {
        return context.dataStore.data.map {
            val sourcesString = it[PREFERRED_SOURCES_FOR_NOTIFICATIONS_KEY] ?: ""
            if (sourcesString.isEmpty()) emptyList() else sourcesString.split(",")
        }
    }

    suspend fun savePreferredSourcesForNotifications(sources: List<String>) {
        context.dataStore.edit {
            it[PREFERRED_SOURCES_FOR_NOTIFICATIONS_KEY] = sources.joinToString(",")
        }
    }

    fun getFilterByTime(): Flow<String> {
        return context.dataStore.data.map {
            it[FILTER_BY_TIME_KEY] ?: "any"
        }
    }

    suspend fun saveFilterByTime(time: String) {
        context.dataStore.edit {
            it[FILTER_BY_TIME_KEY] = time
        }
    }

    fun getFilterByCategory(): Flow<String> {
        return context.dataStore.data.map {
            it[FILTER_BY_CATEGORY_KEY] ?: "all"
        }
    }

    suspend fun saveFilterByCategory(category: String) {
        context.dataStore.edit {
            it[FILTER_BY_CATEGORY_KEY] = category
        }
    }

    fun getFilterByLength(): Flow<String> {
        return context.dataStore.data.map {
            it[FILTER_BY_LENGTH_KEY] ?: "any"
        }
    }

    suspend fun saveFilterByLength(length: String) {
        context.dataStore.edit {
            it[FILTER_BY_LENGTH_KEY] = length
        }
    }

    fun getHighContrastMode(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[HIGH_CONTRAST_MODE_KEY] ?: false
        }
    }

    suspend fun saveHighContrastMode(enabled: Boolean) {
        context.dataStore.edit {
            it[HIGH_CONTRAST_MODE_KEY] = enabled
        }
    }

    fun getSpeechRate(): Flow<Float> {
        return context.dataStore.data.map {
            it[SPEECH_RATE_KEY] ?: 1.0f
        }
    }

    suspend fun saveSpeechRate(rate: Float) {
        context.dataStore.edit {
            it[SPEECH_RATE_KEY] = rate
        }
    }

    // App Lock functions
    fun getAppLockEnabled(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[APP_LOCK_ENABLED_KEY] ?: false
        }
    }

    suspend fun saveAppLockEnabled(enabled: Boolean) {
        context.dataStore.edit {
            it[APP_LOCK_ENABLED_KEY] = enabled
        }
    }

    fun getAppLockType(): Flow<String> {
        return context.dataStore.data.map {
            it[APP_LOCK_TYPE_KEY] ?: "none"
        }
    }

    suspend fun saveAppLockType(type: String) {
        context.dataStore.edit {
            it[APP_LOCK_TYPE_KEY] = type
        }
    }

    fun getAppLockValue(): Flow<String?> {
        return context.dataStore.data.map {
            encryptedSharedPreferences.getString("app_lock_value", null)
        }
    }

    suspend fun saveAppLockValue(value: String) {
        encryptedSharedPreferences.edit().putString("app_lock_value", value).apply()
    }
}


