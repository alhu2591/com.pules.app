package com.pules.app.data.remote;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006\u00c0\u0006\u0003"}, d2 = {"Lcom/pules/app/data/remote/InstagramApiService;", "", "getInstagramData", "", "accessToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface InstagramApiService {
    
    @retrofit2.http.GET(value = "some_instagram_endpoint")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInstagramData(@retrofit2.http.Query(value = "access_token")
    @org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
}