package com.pules.app.data.local.database.entity

import androidx.room.Entity

@Entity(primaryKeys = ["articleId", "tagId"])
data class ArticleTagCrossRef(
    val articleId: String,
    val tagId: Int
)


