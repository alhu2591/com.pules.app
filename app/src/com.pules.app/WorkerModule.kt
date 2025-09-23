package com.pules.app.di

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.pules.app.domain.usecase.GetRecommendedArticlesUseCase
import com.pules.app.domain.usecase.GetSourcesUseCase
import com.pules.app.workers.DailyDigestWorker
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WorkerModule {

    @Provides
    @Singleton
    fun provideDailyDigestWorkerFactory(
        dailyDigestWorkerAssistedFactory: DailyDigestWorker.Factory
    ): PulesWorkerFactory {
        return PulesWorkerFactory(dailyDigestWorkerAssistedFactory)
    }
}

class PulesWorkerFactory(
    private val dailyDigestWorkerAssistedFactory: DailyDigestWorker.Factory
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            DailyDigestWorker::class.java.name ->
                dailyDigestWorkerAssistedFactory.create(appContext, workerParameters)
            else ->
                // Return null for other types of workers. The system will use the default WorkerFactory.
                null
        }
    }
}

@AssistedFactory
interface DailyDigestWorkerFactory {
    fun create(
        @Assisted appContext: Context,
        @Assisted workerParameters: WorkerParameters
    ): DailyDigestWorker
}


