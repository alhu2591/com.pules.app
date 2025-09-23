package com.pules.app.domain.model

data class NotificationConfig(
    val sourceId: Int,
    val enabled: Boolean,
    val type: NotificationType,
    val schedule: NotificationSchedule
)

enum class NotificationType {
    SIMPLE,
    RICH
}

enum class NotificationSchedule {
    ONE_HOUR,
    SIX_HOURS,
    DAILY,
    CUSTOM
}


