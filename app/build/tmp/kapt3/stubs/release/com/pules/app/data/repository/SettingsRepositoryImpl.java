package com.pules.app.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0016J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0 0\bH\u0016J\u001c\u0010!\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0 H\u0096@\u00a2\u0006\u0002\u0010#J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\'\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0016J\u0016\u0010.\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000\bH\u0016J\u0016\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000200H\u0096@\u00a2\u0006\u0002\u00103J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0016J\u0016\u00105\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u0010\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\u0016\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006<"}, d2 = {"Lcom/pules/app/data/repository/SettingsRepositoryImpl;", "Lcom/pules/app/data/repository/interfaces/SettingsRepository;", "settingsDataStore", "error/NonExistentClass", "<init>", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "getThemePreference", "Lkotlinx/coroutines/flow/Flow;", "", "saveThemePreference", "theme", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLanguagePreference", "saveLanguagePreference", "language", "getNotificationPreference", "", "saveNotificationPreference", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiKey", "service", "saveApiKey", "key", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoBackupEnabled", "saveAutoBackupEnabled", "getNotificationFrequency", "saveNotificationFrequency", "frequency", "getPreferredSourcesForNotifications", "", "savePreferredSourcesForNotifications", "sources", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilterByTime", "saveFilterByTime", "time", "getFilterByCategory", "saveFilterByCategory", "category", "getFilterByLength", "saveFilterByLength", "length", "getHighContrastMode", "saveHighContrastMode", "getSpeechRate", "", "saveSpeechRate", "rate", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppLockEnabled", "saveAppLockEnabled", "getAppLockType", "saveAppLockType", "type", "getAppLockValue", "saveAppLockValue", "value", "app_release"})
public final class SettingsRepositoryImpl implements com.pules.app.data.repository.interfaces.SettingsRepository {
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass settingsDataStore = null;
    
    @javax.inject.Inject()
    public SettingsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass settingsDataStore) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getThemePreference() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveThemePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getLanguagePreference() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveLanguagePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> getNotificationPreference() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveNotificationPreference(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAutoBackupEnabled() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveAutoBackupEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getNotificationFrequency() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveNotificationFrequency(@org.jetbrains.annotations.NotNull()
    java.lang.String frequency, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getPreferredSourcesForNotifications() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object savePreferredSourcesForNotifications(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> sources, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByTime() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveFilterByTime(@org.jetbrains.annotations.NotNull()
    java.lang.String time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByCategory() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveFilterByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByLength() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveFilterByLength(@org.jetbrains.annotations.NotNull()
    java.lang.String length, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> getHighContrastMode() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveHighContrastMode(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Float> getSpeechRate() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveSpeechRate(float rate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAppLockEnabled() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveAppLockEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockType() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveAppLockType(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockValue() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveAppLockValue(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super error.NonExistentClass> $completion) {
        return null;
    }
}