package com.pules.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/pules/app/data/repository/SocialMediaRepositoryImpl;", "Lcom/pules/app/data/repository/interfaces/SocialMediaRepository;", "facebookApiService", "Lcom/pules/app/data/remote/FacebookApiService;", "instagramApiService", "Lcom/pules/app/data/remote/InstagramApiService;", "tikTokApiService", "Lcom/pules/app/data/remote/TikTokApiService;", "<init>", "(Lcom/pules/app/data/remote/FacebookApiService;Lcom/pules/app/data/remote/InstagramApiService;Lcom/pules/app/data/remote/TikTokApiService;)V", "getFacebookFeed", "Lkotlinx/coroutines/flow/Flow;", "", "", "apiKey", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstagramFeed", "getTikTokFeed", "app_debug"})
public final class SocialMediaRepositoryImpl implements com.pules.app.data.repository.interfaces.SocialMediaRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.data.remote.FacebookApiService facebookApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.data.remote.InstagramApiService instagramApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pules.app.data.remote.TikTokApiService tikTokApiService = null;
    
    @javax.inject.Inject()
    public SocialMediaRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.pules.app.data.remote.FacebookApiService facebookApiService, @org.jetbrains.annotations.NotNull()
    com.pules.app.data.remote.InstagramApiService instagramApiService, @org.jetbrains.annotations.NotNull()
    com.pules.app.data.remote.TikTokApiService tikTokApiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getFacebookFeed(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<java.lang.String>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getInstagramFeed(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<java.lang.String>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTikTokFeed(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<java.lang.String>>> $completion) {
        return null;
    }
}