package com.pules.app.data.repository

import com.pules.app.data.local.dao.SourceDao
import com.pules.app.data.local.entity.SourceEntity
import com.pules.app.data.repository.interfaces.SourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourceRepositoryImpl @Inject constructor(
    private val sourceDao: SourceDao
) : SourceRepository {
    override fun getAllSources(): Flow<List<SourceEntity>> = sourceDao.getAllSources()

    override suspend fun insertSource(source: SourceEntity) {
        sourceDao.insertSource(source)
    }

    override suspend fun deleteSource(sourceId: String) {
        sourceDao.deleteSource(sourceId)
    }
}


