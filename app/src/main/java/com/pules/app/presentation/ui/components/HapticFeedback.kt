package com.pules.app.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

@Composable
fun rememberHapticFeedback() = LocalHapticFeedback.current

object HapticFeedbackHelper {
    fun performHapticFeedback(
        hapticFeedback: androidx.compose.ui.hapticfeedback.HapticFeedback,
        type: HapticFeedbackType = HapticFeedbackType.LongPress
    ) {
        hapticFeedback.performHapticFeedback(type)
    }
}

