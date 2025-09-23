package com.pules.app.data.repository.interfaces

import com.pules.app.domain.model.Tag
import kotlinx.coroutines.flow.Flow

interface TagRepository {
    fun getAllTags(): Flow<List<Tag>>
    suspend fun addTag(tag: Tag): Long
    suspend fun getTagByName(name: String): Tag?
    suspend fun addTagToArticle(articleId: String, tagId: Int)
    fun getTagsForArticle(articleId: String): Flow<List<String>>
    suspend fun deleteTag(tagId: Int)
    suspend fun removeTagFromArticle(articleId: String, tagId: Int)
}

