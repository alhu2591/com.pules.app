package com.pules.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.viewmodel.SettingsViewModel
import com.pules.app.ui.components.SettingItem
import com.pules.app.ui.components.SettingItemCard
import com.pules.app.ui.components.SettingToggleItem
import com.pules.app.ui.components.SettingToggleItemCard
import com.pules.app.ui.components.ThemeSelectionDialog
import com.pules.app.ui.components.LanguageSelectionDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, viewModel: SettingsViewModel = hiltViewModel()) {
    val themePreference by viewModel.themePreference.collectAsState()
    val languagePreference by viewModel.languagePreference.collectAsState()
    val notificationPreference by viewModel.notificationPreference.collectAsState()
    val highContrastMode by viewModel.highContrastMode.collectAsState()

    var showThemeDialog by remember { mutableStateOf(false) }
    var showLanguageDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("الإعدادات") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "العودة")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                SettingItemCard(
                    setting = SettingItem("المظهر", themePreference, Icons.Default.Palette),
                    onClick = { showThemeDialog = true }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("اللغة", languagePreference, Icons.Default.Language),
                    onClick = { showLanguageDialog = true }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("الإشعارات", "", Icons.Default.NotificationsActive),
                    onClick = { navController.navigate(Screen.NotificationSettings.route) }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("إعدادات التصفية المتقدمة", "", Icons.Default.ChevronRight),
                    onClick = { navController.navigate(Screen.AdvancedFilter.route) }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("إدارة العلامات", "", Icons.Default.ChevronRight),
                    onClick = { navController.navigate(Screen.TagManagement.route) }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("تحليلاتي", "", Icons.Default.ChevronRight),
                    onClick = { navController.navigate(Screen.Analytics.route) }
                )
            }
            item {
                SettingToggleItemCard(
                    setting = SettingToggleItem("وضع التباين العالي", highContrastMode),
                    onToggle = { viewModel.saveHighContrastMode(it) }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("إعدادات متقدمة", "", Icons.Default.ChevronRight),
                    onClick = { navController.navigate(Screen.AdvancedSettings.route) }
                )
            }
        }

        if (showThemeDialog) {
            ThemeSelectionDialog(
                currentTheme = themePreference,
                onDismiss = { showThemeDialog = false },
                onThemeSelected = { theme ->
                    viewModel.saveThemePreference(theme)
                    showThemeDialog = false
                }
            )
        }

        if (showLanguageDialog) {
            LanguageSelectionDialog(
                currentLanguage = languagePreference,
                onDismiss = { showLanguageDialog = false },
                onLanguageSelected = { lang ->
                    viewModel.saveLanguagePreference(lang)
                    showLanguageDialog = false
                }
            )
        }
    }
}



