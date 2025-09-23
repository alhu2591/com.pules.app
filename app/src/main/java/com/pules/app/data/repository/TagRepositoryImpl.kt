package com.pules.app.data.repository

import com.pules.app.data.local.dao.TagDao
import com.pules.app.data.local.entity.ArticleTagCrossRef
import com.pules.app.data.local.entity.TagEntity
import com.pules.app.data.repository.interfaces.TagRepository
import com.pules.app.domain.model.Tag
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TagRepositoryImpl @Inject constructor(
    private val tagDao: TagDao
) : TagRepository {

    override fun getAllTags(): Flow<List<Tag>> {
        return tagDao.getAllTags().map { tags ->
            tags.map { Tag(it.id.toString(), it.name) }
        }
    }

    override suspend fun addTag(tag: Tag): Long {
        return tagDao.insertTag(TagEntity(name = tag.name))
    }

    override suspend fun getTagByName(name: String): Tag? {
        return tagDao.getTagByName(name)?.let { Tag(it.id.toString(), it.name) }
    }

    override suspend fun addTagToArticle(articleId: String, tagId: Int) {
        tagDao.insertArticleTagCrossRef(ArticleTagCrossRef(articleId, tagId))
    }

    override fun getTagsForArticle(articleId: String): Flow<List<String>> {
        return tagDao.getTagsForArticle(articleId)
    }

    override suspend fun deleteTag(tagId: Int) {
        tagDao.deleteTag(tagId)
    }

    override suspend fun removeTagFromArticle(articleId: String, tagId: Int) {
        tagDao.deleteArticleTagCrossRef(articleId, tagId)
    }
}

