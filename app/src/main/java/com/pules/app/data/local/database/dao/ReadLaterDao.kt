package com.pules.app.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pules.app.data.local.entity.ReadLaterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadLaterDao {
    @Query("SELECT * FROM read_later_items")
    fun getAllReadLaterItems(): Flow<List<ReadLaterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReadLaterItem(item: ReadLaterEntity)

    @Query("DELETE FROM read_later_items WHERE id = :itemId")
    suspend fun deleteReadLaterItem(itemId: String)

    @Query("SELECT content FROM read_later_items WHERE id = :itemId")
    suspend fun getReadLaterItemContent(itemId: String): String?
}


