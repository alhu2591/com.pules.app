package com.pules.app.utils

import com.pules.app.domain.model.SourceType

object LinkParser {

    fun parseUrl(url: String): Pair<SourceType, String>? {
        return when {
            url.contains("youtube.com/channel/") -> {
                val channelId = url.substringAfter("youtube.com/channel/").substringBefore("/").substringBefore("?")
                SourceType.YOUTUBE to channelId
            }
            url.contains("youtube.com/user/") -> {
                val username = url.substringAfter("youtube.com/user/").substringBefore("/").substringBefore("?")
                SourceType.YOUTUBE to username
            }
            url.contains("youtube.com/c/") -> {
                val customUrlPart = url.substringAfter("youtube.com/c/").substringBefore("/").substringBefore("?")
                SourceType.YOUTUBE to customUrlPart
            }
            url.contains("twitter.com/") && !url.contains("/status/") -> {
                val username = url.substringAfter("twitter.com/").substringBefore("/").substringBefore("?")
                SourceType.TWITTER to username
            }
            else -> null
        }
    }
}


