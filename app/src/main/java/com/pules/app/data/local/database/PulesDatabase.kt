package com.pules.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pules.app.data.local.database.dao.FavoriteDao
import com.pules.app.data.local.database.dao.NoteDao
import com.pules.app.data.local.database.dao.ReadLaterDao
import com.pules.app.data.local.database.dao.SourceDao
import com.pules.app.data.local.database.dao.TagDao
import com.pules.app.data.local.database.entity.FavoriteEntity
import com.pules.app.data.local.database.entity.NoteEntity
import com.pules.app.data.local.database.entity.ReadLaterEntity
import com.pules.app.data.local.database.entity.SourceEntity
import com.pules.app.data.local.database.entity.TagEntity
import com.pules.app.data.local.database.entity.ArticleTagCrossRef

@Database(entities = [SourceEntity::class, FavoriteEntity::class, ReadLaterEntity::class, NoteEntity::class, TagEntity::class, ArticleTagCrossRef::class], version = 1, exportSchema = false)

abstract class PulesDatabase : RoomDatabase() {
    abstract fun sourceDao(): SourceDao
    abstract fun favoriteDao(): FavoriteDao
    abstract fun readLaterDao(): ReadLaterDao
    abstract fun noteDao(): NoteDao
    abstract fun tagDao(): TagDao
}


