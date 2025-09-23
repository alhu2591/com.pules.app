package com.pules.app.data.repository.interfaces

import com.pules.app.domain.model.ReadLaterItem
import kotlinx.coroutines.flow.Flow

interface ReadLaterRepository {
    fun getAllReadLaterItems(): Flow<List<ReadLaterItem>>
    suspend fun insertReadLaterItem(item: ReadLaterItem)
    suspend fun deleteReadLaterItem(itemId: String)
    suspend fun getReadLaterItemContent(itemId: String): String?
}


