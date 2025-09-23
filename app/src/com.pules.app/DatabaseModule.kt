package com.pules.app.di

import android.content.Context
import androidx.room.Room
import com.pules.app.data.local.dao.FavoriteDao
import com.pules.app.data.local.dao.NoteDao
import com.pules.app.data.local.dao.ReadLaterDao
import com.pules.app.data.local.dao.SourceDao
import com.pules.app.data.local.database.PulesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PulesDatabase {
        return Room.databaseBuilder(
            context,
            PulesDatabase::class.java,
            "pules_database"
        ).build()
    }

    @Provides
    fun provideSourceDao(database: PulesDatabase): SourceDao {
        return database.sourceDao()
    }

    @Provides
    fun provideFavoriteDao(database: PulesDatabase): FavoriteDao {
        return database.favoriteDao()
    }

    @Provides
    fun provideReadLaterDao(database: PulesDatabase): ReadLaterDao {
        return database.readLaterDao()
    }

    @Provides
    fun provideNoteDao(database: PulesDatabase): NoteDao {
        return database.noteDao()
    }
}


