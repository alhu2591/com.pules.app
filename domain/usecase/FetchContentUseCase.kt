package com.pules.app.domain.usecase

import com.pules.app.data.remote.TwitterApiService
import com.pules.app.data.remote.YouTubeApiService
import com.pules.app.data.repository.SettingsRepository
import com.pules.app.data.repository.SourceRepository
import com.pules.app.domain.model.ContentItem
import com.pules.app.domain.model.Source
import com.pules.app.domain.model.SourceType
import kotlinx.coroutines.flow.first
import java.time.Instant
import java.time.format.DateTimeParseException
import javax.inject.Inject

class FetchContentUseCase @Inject constructor(
    private val sourceRepository: SourceRepository,
    private val settingsRepository: SettingsRepository,
    private val youtubeApiService: YouTubeApiService,
    private val twitterApiService: TwitterApiService
) {

    suspend operator fun invoke(source: Source): Result<List<ContentItem>> {
        val youtubeApiKey = settingsRepository.youtubeApiKey.first()
        val twitterBearerToken = settingsRepository.twitterBearerToken.first()

        return try {
            val contentItems = when (source.type) {
                SourceType.YOUTUBE -> {
                    if (youtubeApiKey.isNullOrBlank()) {
                        return Result.failure(Exception("YouTube API key not configured."))
                    }
                    val channelId = extractYouTubeChannelId(source.url)
                        ?: return Result.failure(Exception("Could not extract YouTube channel ID from URL."))

                    val activitiesResponse = youtubeApiService.getChannelActivities(channelId = channelId, apiKey = youtubeApiKey)
                    activitiesResponse.items.mapNotNull { activityItem ->
                        if (activityItem.snippet.type == "upload" && activityItem.contentDetails.upload != null) {
                            ContentItem(
                                id = activityItem.contentDetails.upload.videoId,
                                title = activityItem.snippet.title,
                                description = activityItem.snippet.description,
                                thumbnailUrl = activityItem.snippet.thumbnails.high.url,
                                contentUrl = "https://www.youtube.com/watch?v=" + activityItem.contentDetails.upload.videoId,
                                publishedAt = activityItem.snippet.publishedAt.toEpochMilli(),
                                sourceType = SourceType.YOUTUBE,
                                sourceName = source.name,
                                sourceImageUrl = source.imageUrl
                            )
                        } else {
                            null
                        }
                    }
                }
                SourceType.TWITTER -> {
                    if (twitterBearerToken.isNullOrBlank()) {
                        return Result.failure(Exception("Twitter Bearer Token not configured."))
                    }
                    val username = extractTwitterUsername(source.url)
                        ?: return Result.failure(Exception("Could not extract Twitter username from URL."))

                    val userResponse = twitterApiService.getUserByUsername(username = username, bearerToken = "Bearer $twitterBearerToken")
                    val userId = userResponse.data?.id
                        ?: return Result.failure(Exception(userResponse.errors?.firstOrNull()?.detail ?: "Twitter user not found."))

                    val tweetsResponse = twitterApiService.getUserTweets(userId = userId, bearerToken = "Bearer $twitterBearerToken")
                    tweetsResponse.data?.map { tweetData ->
                        val mediaUrl = tweetsResponse.includes?.media?.firstOrNull { it.media_key == tweetData.attachments?.media_keys?.firstOrNull() }?.url
                        ContentItem(
                            id = tweetData.id,
                            title = tweetData.text.take(50) + if (tweetData.text.length > 50) "..." else "",
                            description = tweetData.text,
                            thumbnailUrl = mediaUrl,
                            contentUrl = "https://twitter.com/${username}/status/${tweetData.id}",
                            publishedAt = tweetData.created_at.toEpochMilli(),
                            sourceType = SourceType.TWITTER,
                            sourceName = source.name,
                            sourceImageUrl = source.imageUrl
                        )
                    } ?: emptyList()
                }
            }
            Result.success(contentItems)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun String.toEpochMilli(): Long {
        return try {
            Instant.parse(this).toEpochMilli()
        } catch (e: DateTimeParseException) {
            System.currentTimeMillis()
        }
    }

    private fun extractYouTubeChannelId(url: String): String? {
        return when {
            url.contains("youtube.com/channel/") -> url.substringAfter("youtube.com/channel/").substringBefore("/").substringBefore("?")
            url.contains("youtube.com/user/") -> null
            url.contains("youtube.com/c/") -> null
            else -> null
        }
    }

    private fun extractTwitterUsername(url: String): String? {
        return if (url.contains("twitter.com/") && !url.contains("/status/")) {
            url.substringAfter("twitter.com/").substringBefore("/").substringBefore("?")
        } else {
            null
        }
    }
}


