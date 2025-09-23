package com.pules.app.domain.usecase.settings;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\r\u001a\u00020\bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u0007J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/pules/app/domain/usecase/settings/GetSettingsUseCase;", "", "settingsRepository", "Lcom/pules/app/data/repository/interfaces/SettingsRepository;", "<init>", "(Lcom/pules/app/data/repository/interfaces/SettingsRepository;)V", "getThemePreference", "Lkotlinx/coroutines/flow/Flow;", "", "getLanguagePreference", "getNotificationPreference", "", "getApiKey", "service", "getAutoBackupEnabled", "getNotificationFrequency", "getPreferredSourcesForNotifications", "", "getFilterByTime", "getFilterByCategory", "getFilterByLength", "getHighContrastMode", "getSpeechRate", "", "getAppLockEnabled", "getAppLockType", "getAppLockValue", "app_release"})
public final class GetSettingsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.data.repository.interfaces.SettingsRepository settingsRepository = null;
    
    @javax.inject.Inject()
    public GetSettingsUseCase(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.repository.interfaces.SettingsRepository settingsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getThemePreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getLanguagePreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getNotificationPreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String service) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAutoBackupEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getNotificationFrequency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getPreferredSourcesForNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getFilterByLength() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getHighContrastMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Float> getSpeechRate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAppLockEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getAppLockValue() {
        return null;
    }
}