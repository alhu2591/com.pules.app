package com.pules.app.domain.usecase

import com.pules.app.data.repository.SettingsRepository
import com.pules.app.workers.ContentCheckWorker
import javax.inject.Inject
import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import java.util.concurrent.TimeUnit

class ScheduleContentCheckUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val settingsRepository: SettingsRepository
) {

    suspend operator fun invoke() {
        val schedule = settingsRepository.notificationSchedule.first()
        val interval = when (schedule) {
            "1h" -> 1L
            "6h" -> 6L
            "1d" -> 24L
            else -> 6L
        }
        val timeUnit = TimeUnit.HOURS

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val contentCheckRequest = PeriodicWorkRequestBuilder<ContentCheckWorker>(interval, timeUnit)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueue(contentCheckRequest)
    }

    fun cancelScheduledChecks() {
        WorkManager.getInstance(context).cancelAllWorkByTag(ContentCheckWorker.TAG)
    }
}


