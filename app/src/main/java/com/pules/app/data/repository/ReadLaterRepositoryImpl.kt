package com.pules.app.data.repository

import com.pules.app.data.local.dao.ReadLaterDao
import com.pules.app.data.local.entity.ReadLaterEntity
import com.pules.app.data.repository.interfaces.ReadLaterRepository
import com.pules.app.domain.model.ReadLaterItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ReadLaterRepositoryImpl @Inject constructor(
    private val readLaterDao: ReadLaterDao
) : ReadLaterRepository {
    override fun getAllReadLaterItems(): Flow<List<ReadLaterItem>> = readLaterDao.getAllReadLaterItems().map {
        it.map { entity ->
            ReadLaterItem(
                id = entity.id,
                title = entity.title,
                url = entity.url,
                imageUrl = entity.imageUrl,
                publishedAt = entity.publishedAt,
                sourceId = entity.sourceId,
                content = entity.content
            )
        }
    }

    override suspend fun insertReadLaterItem(item: ReadLaterItem) {
        readLaterDao.insertReadLaterItem(
            ReadLaterEntity(
                id = item.id,
                title = item.title,
                url = item.url,
                imageUrl = item.imageUrl,
                publishedAt = item.publishedAt,
                sourceId = item.sourceId,
                content = item.content
            )
        )
    }

    override suspend fun deleteReadLaterItem(itemId: String) {
        readLaterDao.deleteReadLaterItem(itemId)
    }

    override suspend fun getReadLaterItemContent(itemId: String): String? {
        return readLaterDao.getReadLaterItemContent(itemId)
    }
}


