package com.pules.app.domain.model

data class Note(
    val id: Int = 0,
    val articleId: String,
    val noteContent: String,
    val timestamp: Long
)


