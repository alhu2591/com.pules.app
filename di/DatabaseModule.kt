package com.pules.app.di

import android.content.Context
import androidx.room.Room
import com.pules.app.data.local.database.PulesDatabase
import com.pules.app.data.local.database.Dao.FavoriteDao
import com.pules.app.data.local.database.Dao.ReadLaterDao
import com.pules.app.data.local.database.Dao.SourceDao
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
    fun provideDatabase(@ApplicationContext appContext: Context): PulesDatabase {
        return Room.databaseBuilder(
            appContext,
            PulesDatabase::class.java,
            "pules-database"
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
}


