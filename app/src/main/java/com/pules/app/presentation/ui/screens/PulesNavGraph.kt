package com.pules.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pules.app.ui.components.BottomNavigationBar

import com.pules.app.OnboardingScreen
import com.pules.app.HomeScreen
import com.pules.app.SourcesScreen
import com.pules.app.MyLibraryScreen
import com.pules.app.SettingsScreen
import com.pules.app.SearchScreen
import com.pules.app.AdvancedSettingsScreen
import com.pules.app.ReadingModeScreen
import com.pules.app.NotesScreen
import com.pules.app.AppLockSettingsScreen


sealed class Screen(val route: String, val title: String, val icon: ImageVector?) {
    object Onboarding : Screen("onboarding", "Onboarding", null)
    object Home : Screen("home", "الرئيسية", Icons.Default.Home)
    object Sources : Screen("sources", "المصادر", Icons.Default.List)
    object MyLibrary : Screen("my_library", "مكتبتي", Icons.Default.LibraryBooks)
    object Settings : Screen("settings", "الإعدادات", Icons.Default.Settings)
    object Search : Screen("search", "بحث", Icons.Default.Search)
    object AdvancedSettings : Screen("advanced_settings", "إعدادات متقدمة", null)
    object NotificationSettings : Screen("notification_settings", "إعدادات الإشعارات", null)
    object AdvancedFilter : Screen("advanced_filter", "إعدادات التصفية المتقدمة", null)
    object TagManagement : Screen("tag_management", "إدارة العلامات", null)
    object Analytics : Screen("analytics", "تحليلاتي", null)
    object AppLockSettings : Screen("app_lock_settings", "قفل التطبيق", Icons.Default.Lock)




    object SourceDetail : Screen("source_detail/{sourceId}", "تفاصيل المصدر", null) {
        fun createRoute(sourceId: String?) = "source_detail/${sourceId ?: "{sourceId}"}"
    }
    object ReadingMode : Screen("reading_mode/{articleContent}/{articleId}", "وضع القراءة", null) { // Added ReadingMode
        fun createRoute(articleContent: String, articleId: String) = "reading_mode/$articleContent/$articleId"
    }
    object Notes : Screen("notes/{articleId}", "ملاحظاتي", Icons.Default.Notes) {
        fun createRoute(articleId: String) = "notes/$articleId"
    }
    // Keep ReadLater and Favorites for internal navigation if needed, but not in bottom bar
    object ReadLater : Screen("read_later", "قراءة لاحقًا", Icons.Default.Star)
    object Favorites : Screen("favorites", "المفضلة", Icons.Default.Favorite)
}

@Composable
fun PulesNavGraph(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    val isOnboardingCompleted by mainViewModel.isOnboardingCompleted.collectAsState()

    val screens = listOf(
        Screen.Home,
        Screen.Sources,
        Screen.MyLibrary,
        Screen.Settings
    )

    val startDestination = if (isOnboardingCompleted) Screen.Home.route else Screen.Onboarding.route

    Scaffold(
        bottomBar = {
            if (isOnboardingCompleted) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = startDestination, modifier = Modifier.padding(paddingValues)) {
            composable(Screen.Onboarding.route) {
                Crossfade(targetState = it.destination.route) {
                    OnboardingScreen(navController = navController) {
                        mainViewModel.completeOnboarding()
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Onboarding.route) { inclusive = true }
                        }
                    }
                }
            }
            composable(Screen.Home.route) {
                Crossfade(targetState = it.destination.route) {
                    HomeScreen(navController = navController) {
                        navController.navigate(Screen.Search.route)
                    }
                }
            }
            composable(Screen.Sources.route) {
                Crossfade(targetState = it.destination.route) {
                    SourcesScreen(navController = navController)
                }
            }
            composable(Screen.MyLibrary.route) {
                Crossfade(targetState = it.destination.route) {
                    MyLibraryScreen(navController = navController)
                }
            }
            composable(Screen.Settings.route) {
                Crossfade(targetState = it.destination.route) {
                    SettingsScreen(navController = navController)
                }
            }
            composable(Screen.Search.route) {
                Crossfade(targetState = it.destination.route) {
                    SearchScreen(navController = navController)
                }
            }
            composable(Screen.AdvancedSettings.route) {
                Crossfade(targetState = it.destination.route) {
                    AdvancedSettingsScreen(navController = navController)
                }
            }
            composable(Screen.NotificationSettings.route) {
                Crossfade(targetState = it.destination.route) {
                    NotificationSettingsScreen(navController = navController)
                }
            }
            composable(Screen.AdvancedFilter.route) {
                Crossfade(targetState = it.destination.route) {
                    AdvancedFilterScreen(navController = navController)
                }
            }
            composable(Screen.TagManagement.route) {
                Crossfade(targetState = it.destination.route) {
                    TagManagementScreen(navController = navController)
                }
            }
            composable(Screen.Analytics.route) {
                Crossfade(targetState = it.destination.route) {
                    AnalyticsScreen(navController = navController)
                }
            }
            composable(Screen.AppLockSettings.route) {
                Crossfade(targetState = it.destination.route) {
                    AppLockSettingsScreen(navController = navController)
                }
            }
            composable(Screen.SourceDetail.route) {
                val sourceId = it.arguments?.getString("sourceId")
                Crossfade(targetState = it.destination.route) {
                    SourceDetailScreen(navController = navController, sourceId = sourceId)
                }
            }
            composable(Screen.ReadingMode.route) {
                val articleContent = it.arguments?.getString("articleContent") ?: ""
                val articleId = it.arguments?.getString("articleId") ?: ""
                Crossfade(targetState = it.destination.route) {
                    ReadingModeScreen(navController = navController, articleContent = articleContent, articleId = articleId)
                }
            }
            composable(Screen.Notes.route) {
                val articleId = it.arguments?.getString("articleId") ?: ""
                Crossfade(targetState = it.destination.route) {
                    NotesScreen(navController = navController, articleId = articleId)
                }
            }
            composable(Screen.Favorites.route) {
                Crossfade(targetState = it.destination.route) {
                    FavoritesScreen(navController = navController)
                }
            }
            composable(Screen.ReadLater.route) {
                Crossfade(targetState = it.destination.route) {
                    ReadLaterScreen(navController = navController)
                }
            }
        }
    }
}


