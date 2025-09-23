package com.pules.app.data.repository.interfaces;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0004H&J\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001c0\u0003H&J\u001c\u0010\u001d\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u00a6@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0003H&J\u0016\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020,H\u00a6@\u00a2\u0006\u0002\u0010/J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u0016\u00101\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0010\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J\u0016\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u00068\u00c0\u0006\u0003"}, d2 = {"Lcom/pules/app/data/repository/interfaces/SettingsRepository;", "", "getThemePreference", "Lkotlinx/coroutines/flow/Flow;", "", "saveThemePreference", "", "theme", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLanguagePreference", "saveLanguagePreference", "language", "getNotificationPreference", "", "saveNotificationPreference", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiKey", "service", "saveApiKey", "key", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoBackupEnabled", "saveAutoBackupEnabled", "getNotificationFrequency", "saveNotificationFrequency", "frequency", "getPreferredSourcesForNotifications", "", "savePreferredSourcesForNotifications", "sources", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilterByTime", "saveFilterByTime", "time", "getFilterByCategory", "saveFilterByCategory", "category", "getFilterByLength", "saveFilterByLength", "length", "getHighContrastMode", "saveHighContrastMode", "getSpeechRate", "", "saveSpeechRate", "rate", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppLockEnabled", "saveAppLockEnabled", "getAppLockType", "saveAppLockType", "type", "getAppLockValue", "saveAppLockValue", "value", "app_release"})
public abstract interface SettingsRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getThemePreference();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveThemePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getLanguagePreference();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveLanguagePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> getNotificationPreference();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveNotificationPreference(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAutoBackupEnabled();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveAutoBackupEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getNotificationFrequency();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveNotificationFrequency(@org.jetbrains.annotations.NotNull()
    java.lang.String frequency, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getPreferredSourcesForNotifications();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object savePreferredSourcesForNotifications(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> sources, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByTime();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveFilterByTime(@org.jetbrains.annotations.NotNull()
    java.lang.String time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByCategory();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveFilterByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByLength();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveFilterByLength(@org.jetbrains.annotations.NotNull()
    java.lang.String length, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> getHighContrastMode();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveHighContrastMode(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Float> getSpeechRate();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveSpeechRate(float rate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAppLockEnabled();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveAppLockEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockType();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveAppLockType(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockValue();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveAppLockValue(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}