package com.pules.app.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.pules.app.data.repository.SourceRepository
import com.pules.app.domain.usecase.FetchContentUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class ContentCheckWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val sourceRepository: SourceRepository,
    private val fetchContentUseCase: FetchContentUseCase
) : CoroutineWorker(appContext, workerParams) {

    companion object {
        const val TAG = "ContentCheckWorker"
    }

    override suspend fun doWork(): Result {
        return try {
            val sources = sourceRepository.getAllSources().first()
            sources.forEach { sourceEntity ->
                val sourceDomain = sourceEntity.toDomainModel() // Convert entity to domain model
                val result = fetchContentUseCase(sourceDomain)
                result.onSuccess { contentItems ->
                    // TODO: Process new content, send notifications
                    // For now, just log or update lastContentDate in SourceEntity
                    if (contentItems.isNotEmpty()) {
                        val latestContentDate = contentItems.maxOfOrNull { it.publishedAt }
                        if (latestContentDate != null && latestContentDate > (sourceEntity.lastContentDate ?: 0L)) {
                            sourceRepository.updateSource(sourceEntity.copy(lastContentDate = latestContentDate))
                        }
                    }
                }.onFailure { e ->
                    // Log error for specific source
                    println("Error fetching content for ${sourceEntity.name}: ${e.message}")
                }
            }
            Result.success()
        } catch (e: Exception) {
            println("Error in ContentCheckWorker: ${e.message}")
            Result.failure()
        }
    }

    private fun com.pules.app.data.local.database.entities.SourceEntity.toDomainModel(): com.pules.app.domain.model.Source {
        return com.pules.app.domain.model.Source(
            id = this.id,
            name = this.name,
            url = this.url,
            type = com.pules.app.domain.model.SourceType.valueOf(this.type.uppercase()),
            imageUrl = this.imageUrl,
            followersCount = this.followersCount,
            lastContentDate = this.lastContentDate
        )
    }
}


