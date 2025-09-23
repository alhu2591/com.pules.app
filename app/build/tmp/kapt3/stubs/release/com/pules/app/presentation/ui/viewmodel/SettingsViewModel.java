package com.pules.app.presentation.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e2\u0006\u0010-\u001a\u00020\fJ\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\fJ\u000e\u00101\u001a\u00020/2\u0006\u00100\u001a\u00020\fJ\u000e\u00102\u001a\u00020/2\u0006\u00100\u001a\u00020\fJ\u000e\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020\fJ\u000e\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\fJ\u000e\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020\u0015J\u0016\u0010C\u001a\u00020/2\u0006\u0010-\u001a\u00020\f2\u0006\u00100\u001a\u00020\fJ\u0018\u0010D\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0002J\u000e\u0010E\u001a\u00020/2\u0006\u0010B\u001a\u00020\u0015J\u000e\u0010F\u001a\u00020/2\u0006\u0010B\u001a\u00020\u0015J\u000e\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020\fJ\u000e\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020\fJ\b\u0010K\u001a\u00020/H\u0002J\b\u0010L\u001a\u00020/H\u0002J\b\u0010M\u001a\u00020/H\u0002J\b\u0010N\u001a\u00020/H\u0002J\u0006\u0010O\u001a\u00020/J\u000e\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001c0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001c0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\"\u0010\u001f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0 0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0 0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0010R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0010R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0010R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0010R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0010\u00a8\u0006R"}, d2 = {"Lcom/pules/app/presentation/ui/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "getSettingsUseCase", "Lcom/pules/app/domain/usecase/settings/GetSettingsUseCase;", "updateSettingsUseCase", "Lcom/pules/app/domain/usecase/settings/UpdateSettingsUseCase;", "context", "Landroid/content/Context;", "<init>", "(Lcom/pules/app/domain/usecase/settings/GetSettingsUseCase;Lcom/pules/app/domain/usecase/settings/UpdateSettingsUseCase;Landroid/content/Context;)V", "_themePreference", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "themePreference", "Lkotlinx/coroutines/flow/StateFlow;", "getThemePreference", "()Lkotlinx/coroutines/flow/StateFlow;", "_languagePreference", "languagePreference", "getLanguagePreference", "_notificationPreference", "", "notificationPreference", "getNotificationPreference", "_notificationFrequency", "notificationFrequency", "getNotificationFrequency", "_preferredSourcesForNotifications", "", "preferredSourcesForNotifications", "getPreferredSourcesForNotifications", "_apiKeys", "", "apiKeys", "getApiKeys", "_appLockEnabled", "appLockEnabled", "getAppLockEnabled", "_appLockType", "appLockType", "getAppLockType", "_appLockValue", "appLockValue", "getAppLockValue", "getApiKey", "service", "saveFacebookApiKey", "", "key", "saveInstagramApiKey", "saveTikTokApiKey", "_autoBackupEnabled", "autoBackupEnabled", "getAutoBackupEnabled", "_highContrastMode", "highContrastMode", "getHighContrastMode", "_speechRate", "", "speechRate", "getSpeechRate", "saveThemePreference", "theme", "saveLanguagePreference", "language", "saveNotificationPreference", "enabled", "saveApiKey", "validateApiKey", "saveAutoBackupEnabled", "saveAppLockEnabled", "saveAppLockType", "type", "saveAppLockValue", "value", "scheduleNotifications", "cancelNotifications", "scheduleAutoBackup", "cancelAutoBackup", "triggerOneTimeBackup", "saveSpeechRate", "rate", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.settings.GetSettingsUseCase getSettingsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.domain.usecase.settings.UpdateSettingsUseCase updateSettingsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _themePreference = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> themePreference = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _languagePreference = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> languagePreference = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _notificationPreference = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> notificationPreference = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _notificationFrequency = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> notificationFrequency = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _preferredSourcesForNotifications = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> preferredSourcesForNotifications = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.lang.String>> _apiKeys = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.String>> apiKeys = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _appLockEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> appLockEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _appLockType = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> appLockType = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _appLockValue = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> appLockValue = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _autoBackupEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> autoBackupEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _highContrastMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> highContrastMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> _speechRate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> speechRate = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.settings.GetSettingsUseCase getSettingsUseCase, @org.jetbrains.annotations.NotNull()
    com.pules.app.domain.usecase.settings.UpdateSettingsUseCase updateSettingsUseCase, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getThemePreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getLanguagePreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotificationPreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getNotificationFrequency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getPreferredSourcesForNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.String>> getApiKeys() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getAppLockEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getAppLockType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getAppLockValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service) {
        return null;
    }
    
    public final void saveFacebookApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void saveInstagramApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void saveTikTokApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getAutoBackupEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getHighContrastMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Float> getSpeechRate() {
        return null;
    }
    
    public final void saveThemePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String theme) {
    }
    
    public final void saveLanguagePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String language) {
    }
    
    public final void saveNotificationPreference(boolean enabled) {
    }
    
    public final void saveApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    private final boolean validateApiKey(java.lang.String service, java.lang.String key) {
        return false;
    }
    
    public final void saveAutoBackupEnabled(boolean enabled) {
    }
    
    public final void saveAppLockEnabled(boolean enabled) {
    }
    
    public final void saveAppLockType(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
    }
    
    public final void saveAppLockValue(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    private final void scheduleNotifications() {
    }
    
    private final void cancelNotifications() {
    }
    
    private final void scheduleAutoBackup() {
    }
    
    private final void cancelAutoBackup() {
    }
    
    public final void triggerOneTimeBackup() {
    }
    
    public final void saveSpeechRate(float rate) {
    }
}