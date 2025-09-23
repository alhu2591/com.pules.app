package com.pules.app.di

import com.pules.app.data.repository.FavoriteRepositoryImpl
import com.pules.app.data.repository.NoteRepositoryImpl
import com.pules.app.data.repository.ReadLaterRepositoryImpl
import com.pules.app.data.repository.SettingsRepositoryImpl
import com.pules.app.data.repository.SourceRepositoryImpl
import com.pules.app.data.repository.interfaces.FavoriteRepository
import com.pules.app.data.repository.interfaces.NoteRepository
import com.pules.app.data.repository.interfaces.ReadLaterRepository
import com.pules.app.data.repository.interfaces.SettingsRepository
import com.pules.app.data.repository.interfaces.SourceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSourceRepository(sourceRepositoryImpl: SourceRepositoryImpl): SourceRepository

    @Binds
    @Singleton
    abstract fun bindFavoriteRepository(favoriteRepositoryImpl: FavoriteRepositoryImpl): FavoriteRepository

    @Binds
    @Singleton
    abstract fun bindReadLaterRepository(readLaterRepositoryImpl: ReadLaterRepositoryImpl): ReadLaterRepository

    @Binds
    @Singleton
    abstract fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository

    @Binds
    @Singleton
    abstract fun bindNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository

    @Binds
    @Singleton
    abstract fun bindBackupRepository(backupRepositoryImpl: com.pules.app.data.repository.BackupRepositoryImpl): com.pules.app.data.repository.interfaces.BackupRepository

    @Binds
    @Singleton
    abstract fun bindTagRepository(tagRepositoryImpl: com.pules.app.data.repository.TagRepositoryImpl): com.pules.app.data.repository.interfaces.TagRepository
}


