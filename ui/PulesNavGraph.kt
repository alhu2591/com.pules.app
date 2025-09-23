package com.pules.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pules.app.ui.screens.favorites.FavoritesScreen
import com.pules.app.ui.screens.home.HomeScreen
import com.pules.app.ui.screens.readlater.ReadLaterScreen
import com.pules.app.ui.screens.settings.SettingsScreen
import com.pules.app.ui.screens.sources.SourcesScreen
import androidx.compose.ui.Modifier
import androidx.navigation.navigation
import com.pules.app.ui.screens.settings.appearance.AppearanceSettings
import com.pules.app.ui.screens.settings.language.LanguageSettings
import com.pules.app.ui.screens.settings.notifications.NotificationsSettings
import com.pules.app.ui.screens.settings.apikeys.ApiKeysSettings
import com.pules.app.ui.screens.settings.backup.BackupSettings
import com.pules.app.ui.screens.settings.privacy.PrivacySettings

object PulesDestinations {
    const val HOME_ROUTE = "home"
    const val FAVORITES_ROUTE = "favorites"
    const val READ_LATER_ROUTE = "read_later"
    const val SOURCES_ROUTE = "sources"
    const val SETTINGS_ROUTE = "settings"

    const val SETTINGS_GRAPH_ROUTE = "settings_graph"
    const val APPEARANCE_SETTINGS_ROUTE = "settings/appearance"
    const val LANGUAGE_SETTINGS_ROUTE = "settings/language"
    const val NOTIFICATIONS_SETTINGS_ROUTE = "settings/notifications"
    const val API_KEYS_SETTINGS_ROUTE = "settings/api_keys"
    const val BACKUP_SETTINGS_ROUTE = "settings/backup"
    const val PRIVACY_SETTINGS_ROUTE = "settings/privacy"
}

@Composable
fun PulesNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = PulesDestinations.HOME_ROUTE, modifier = modifier) {
        composable(PulesDestinations.HOME_ROUTE) {
            HomeScreen()
        }
        composable(PulesDestinations.FAVORITES_ROUTE) {
            FavoritesScreen()
        }
        composable(PulesDestinations.READ_LATER_ROUTE) {
            ReadLaterScreen()
        }
        composable(PulesDestinations.SOURCES_ROUTE) {
            SourcesScreen()
        }
        navigation(startDestination = PulesDestinations.SETTINGS_ROUTE, route = PulesDestinations.SETTINGS_GRAPH_ROUTE) {
            composable(PulesDestinations.SETTINGS_ROUTE) {
                SettingsScreen(navController = navController)
            }
            composable(PulesDestinations.APPEARANCE_SETTINGS_ROUTE) {
                AppearanceSettings(navController = navController)
            }
            composable(PulesDestinations.LANGUAGE_SETTINGS_ROUTE) {
                LanguageSettings(navController = navController)
            }
            composable(PulesDestinations.NOTIFICATIONS_SETTINGS_ROUTE) {
                NotificationsSettings(navController = navController)
            }
            composable(PulesDestinations.API_KEYS_SETTINGS_ROUTE) {
                ApiKeysSettings(navController = navController)
            }
            composable(PulesDestinations.BACKUP_SETTINGS_ROUTE) {
                BackupSettings(navController = navController)
            }
            composable(PulesDestinations.PRIVACY_SETTINGS_ROUTE) {
                PrivacySettings(navController = navController)
            }
        }
    }
}


