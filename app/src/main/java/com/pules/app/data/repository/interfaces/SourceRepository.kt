package com.pules.app.data.repository.interfaces

import com.pules.app.data.local.entity.SourceEntity
import kotlinx.coroutines.flow.Flow

interface SourceRepository {
    fun getAllSources(): Flow<List<SourceEntity>>
    suspend fun insertSource(source: SourceEntity)
    suspend fun deleteSource(sourceId: String)
}


