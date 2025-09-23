package com.pules.app.data.local.preferences;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001eJ\u0016\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eJ\u0016\u0010\'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010)J\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001e2\u0006\u0010+\u001a\u00020\bJ\u001e\u0010,\u001a\u00020 2\u0006\u0010+\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010.J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eJ\u0016\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010)J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eJ\u0016\u00103\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010)J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u001eJ\u0016\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"J\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b080\u001eJ\u001c\u00109\u001a\u00020 2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b08H\u0086@\u00a2\u0006\u0002\u0010;J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0\u001eJ\u0016\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\u001eJ\u0016\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0\u001eJ\u0016\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"J\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eJ\u0016\u0010F\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010)J\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eJ\u0016\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010JJ\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eJ\u0016\u0010L\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010)J\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\b0\u001eJ\u0016\u0010N\u001a\u00020 2\u0006\u0010O\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"J\u000e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001eJ\u0016\u0010Q\u001a\u00020 2\u0006\u0010R\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u00070\b\u00a2\u0006\u0002\b\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u00070\u001c\u00a2\u0006\u0002\b\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lcom/pules/app/data/local/preferences/SettingsDataStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "THEME_PREFERENCE_KEY", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "LANGUAGE_PREFERENCE_KEY", "NOTIFICATION_PREFERENCE_KEY", "", "ONBOARDING_COMPLETED_KEY", "AUTO_BACKUP_ENABLED_KEY", "NOTIFICATION_FREQUENCY_KEY", "PREFERRED_SOURCES_FOR_NOTIFICATIONS_KEY", "FILTER_BY_TIME_KEY", "FILTER_BY_CATEGORY_KEY", "FILTER_BY_LENGTH_KEY", "HIGH_CONTRAST_MODE_KEY", "SPEECH_RATE_KEY", "", "APP_LOCK_ENABLED_KEY", "APP_LOCK_TYPE_KEY", "APP_LOCK_VALUE_KEY", "masterKeyAlias", "Lorg/jspecify/annotations/NonNull;", "encryptedSharedPreferences", "Landroid/content/SharedPreferences;", "getThemePreference", "Lkotlinx/coroutines/flow/Flow;", "saveThemePreference", "", "theme", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLanguagePreference", "saveLanguagePreference", "language", "getNotificationPreference", "saveNotificationPreference", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiKey", "service", "saveApiKey", "key", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOnboardingCompleted", "saveOnboardingCompleted", "completed", "getAutoBackupEnabled", "saveAutoBackupEnabled", "getNotificationFrequency", "saveNotificationFrequency", "frequency", "getPreferredSourcesForNotifications", "", "savePreferredSourcesForNotifications", "sources", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilterByTime", "saveFilterByTime", "time", "getFilterByCategory", "saveFilterByCategory", "category", "getFilterByLength", "saveFilterByLength", "length", "getHighContrastMode", "saveHighContrastMode", "getSpeechRate", "saveSpeechRate", "rate", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppLockEnabled", "saveAppLockEnabled", "getAppLockType", "saveAppLockType", "type", "getAppLockValue", "saveAppLockValue", "value", "app_release"})
public final class SettingsDataStore {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> THEME_PREFERENCE_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> LANGUAGE_PREFERENCE_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> NOTIFICATION_PREFERENCE_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> ONBOARDING_COMPLETED_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> AUTO_BACKUP_ENABLED_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> NOTIFICATION_FREQUENCY_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> PREFERRED_SOURCES_FOR_NOTIFICATIONS_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> FILTER_BY_TIME_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> FILTER_BY_CATEGORY_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> FILTER_BY_LENGTH_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> HIGH_CONTRAST_MODE_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Float> SPEECH_RATE_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> APP_LOCK_ENABLED_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> APP_LOCK_TYPE_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> APP_LOCK_VALUE_KEY = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String masterKeyAlias = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences encryptedSharedPreferences = null;
    
    @javax.inject.Inject()
    public SettingsDataStore(@error.NonExistentClass()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getThemePreference() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveThemePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getLanguagePreference() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveLanguagePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getNotificationPreference() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveNotificationPreference(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isOnboardingCompleted() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveOnboardingCompleted(boolean completed, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAutoBackupEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAutoBackupEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getNotificationFrequency() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveNotificationFrequency(@org.jetbrains.annotations.NotNull()
    java.lang.String frequency, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getPreferredSourcesForNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object savePreferredSourcesForNotifications(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> sources, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveFilterByTime(@org.jetbrains.annotations.NotNull()
    java.lang.String time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveFilterByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByLength() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveFilterByLength(@org.jetbrains.annotations.NotNull()
    java.lang.String length, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getHighContrastMode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveHighContrastMode(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Float> getSpeechRate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveSpeechRate(float rate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAppLockEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAppLockEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAppLockType(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAppLockValue(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}