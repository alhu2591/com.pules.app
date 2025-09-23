package com.pules.app.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Custom color palette for Pules app
private val PulesBlue = Color(0xFF1976D2)
private val PulesBlueVariant = Color(0xFF1565C0)
private val PulesLightBlue = Color(0xFF42A5F5)
private val PulesAccent = Color(0xFF03DAC6)
private val PulesError = Color(0xFFB00020)
private val PulesWarning = Color(0xFFFF9800)
private val PulesSuccess = Color(0xFF4CAF50)

private val DarkColorScheme = darkColorScheme(
    primary = PulesLightBlue,
    onPrimary = Color.White,
    primaryContainer = PulesBlueVariant,
    onPrimaryContainer = Color.White,
    secondary = PulesAccent,
    onSecondary = Color.Black,
    secondaryContainer = PulesAccent.copy(alpha = 0.3f),
    onSecondaryContainer = Color.White,
    tertiary = PulesWarning,
    onTertiary = Color.White,
    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE0E0E0),
    surfaceVariant = Color(0xFF2C2C2C),
    onSurfaceVariant = Color(0xFFB0B0B0),
    error = PulesError,
    onError = Color.White,
    outline = Color(0xFF404040),
    outlineVariant = Color(0xFF606060)
)

private val LightColorScheme = lightColorScheme(
    primary = PulesBlue,
    onPrimary = Color.White,
    primaryContainer = PulesLightBlue.copy(alpha = 0.1f),
    onPrimaryContainer = PulesBlueVariant,
    secondary = PulesAccent,
    onSecondary = Color.White,
    secondaryContainer = PulesAccent.copy(alpha = 0.1f),
    onSecondaryContainer = PulesBlueVariant,
    tertiary = PulesWarning,
    onTertiary = Color.White,
    background = Color(0xFFFFFBFE),
    onBackground = Color(0xFF1C1B1F),
    surface = Color.White,
    onSurface = Color(0xFF1C1B1F),
    surfaceVariant = Color(0xFFF5F5F5),
    onSurfaceVariant = Color(0xFF666666),
    error = PulesError,
    onError = Color.White,
    outline = Color(0xFFE0E0E0),
    outlineVariant = Color(0xFFF0F0F0)
)

@Composable
fun PulesAppTheme(
    themePreference: String,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themePreference) {
        "dark" -> true
        "light" -> false
        else -> isSystemInDarkTheme()
    }

    val colorScheme = when {
        // Dynamic color is available on Android 12+
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


