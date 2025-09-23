package com.pules.app.domain.usecase

import com.pules.app.data.repository.SourceRepository
import com.pules.app.data.repository.SettingsRepository
import com.pules.app.domain.model.Source
import com.pules.app.domain.model.SourceType
import com.pules.app.data.remote.YouTubeApiService
import com.pules.app.data.remote.TwitterApiService
import com.pules.app.data.local.database.entities.SourceEntity
import com.pules.app.utils.LinkParser
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AddSourceUseCase @Inject constructor(
    private val sourceRepository: SourceRepository,
    private val settingsRepository: SettingsRepository,
    private val youtubeApiService: YouTubeApiService,
    private val twitterApiService: TwitterApiService
) {
    suspend operator fun invoke(url: String): Result<Source> {
        val youtubeApiKey = settingsRepository.youtubeApiKey.first()
        val twitterBearerToken = settingsRepository.twitterBearerToken.first()

        val (sourceType, id) = LinkParser.parseUrl(url)
            ?: return Result.failure(IllegalArgumentException("Unsupported URL or unable to determine source type."))

        return try {
            val sourceEntity = when (sourceType) {
                SourceType.YOUTUBE -> {
                    if (youtubeApiKey.isNullOrBlank()) {
                        return Result.failure(Exception("YouTube API key not configured. Please add it in settings."))
                    }
                    val channelResponse = youtubeApiService.getChannelDetails(channelId = id, apiKey = youtubeApiKey)
                    val channelItem = channelResponse.items.firstOrNull()
                        ?: return Result.failure(Exception("YouTube channel not found or API error."))
                    SourceEntity(
                        name = channelItem.snippet.title,
                        url = url,
                        type = SourceType.YOUTUBE.name.lowercase(),
                        imageUrl = channelItem.snippet.thumbnails.high.url,
                        followersCount = channelItem.statistics.subscriberCount.toIntOrNull(),
                        lastContentDate = null
                    )
                }
                SourceType.TWITTER -> {
                    if (twitterBearerToken.isNullOrBlank()) {
                        return Result.failure(Exception("Twitter Bearer Token not configured. Please add it in settings."))
                    }
                    val username = id
                    val userResponse = twitterApiService.getUserByUsername(username = username, bearerToken = "Bearer $twitterBearerToken")
                    val userData = userResponse.data
                        ?: return Result.failure(Exception(userResponse.errors?.firstOrNull()?.detail ?: "Twitter user not found or API error."))
                    SourceEntity(
                        name = userData.name,
                        url = url,
                        type = SourceType.TWITTER.name.lowercase(),
                        imageUrl = userData.profile_image_url?.replace("_normal", ""),
                        followersCount = userData.public_metrics?.followers_count,
                        lastContentDate = null
                    )
                }
            }
            sourceRepository.insertSource(sourceEntity)
            Result.success(sourceEntity.toDomainModel())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun SourceEntity.toDomainModel(): Source {
        return Source(
            id = this.id,
            name = this.name,
            url = this.url,
            type = SourceType.valueOf(this.type.uppercase()),
            imageUrl = this.imageUrl,
            followersCount = this.followersCount,
            lastContentDate = this.lastContentDate
        )
    }
}


