package com.pules.app.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.pules.app.data.local.database.entity.ArticleTagCrossRef
import com.pules.app.data.local.database.entity.TagEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTag(tag: TagEntity): Long

    @Query("SELECT * FROM tags")
    fun getAllTags(): Flow<List<TagEntity>>

    @Query("SELECT * FROM tags WHERE name = :name")
    suspend fun getTagByName(name: String): TagEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleTagCrossRef(crossRef: ArticleTagCrossRef)

    @Transaction
    @Query("SELECT T.name FROM tags T INNER JOIN ArticleTagCrossRef ATC ON T.id = ATC.tagId WHERE ATC.articleId = :articleId")
    fun getTagsForArticle(articleId: String): Flow<List<String>>

    @Query("DELETE FROM tags WHERE id = :tagId")
    suspend fun deleteTag(tagId: Int)

    @Query("DELETE FROM ArticleTagCrossRef WHERE articleId = :articleId AND tagId = :tagId")
    suspend fun deleteArticleTagCrossRef(articleId: String, tagId: Int)
}


