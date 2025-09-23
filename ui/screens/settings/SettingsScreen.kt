package com.pules.app.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pules.app.ui.PulesDestinations
import com.pules.app.ui.theme.PulesTheme
import com.pules.app.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val appTheme by viewModel.appTheme.collectAsState()
    val fontSize by viewModel.fontSize.collectAsState()
    val primaryColor by viewModel.primaryColor.collectAsState()
    val appLanguage by viewModel.appLanguage.collectAsState()
    val notificationsEnabled by viewModel.notificationsEnabled.collectAsState()
    val notificationType by viewModel.notificationType.collectAsState()
    val notificationSchedule by viewModel.notificationSchedule.collectAsState()
    val youtubeApiKey by viewModel.youtubeApiKey.collectAsState()
    val twitterBearerToken by viewModel.twitterBearerToken.collectAsState()
    val analyticsEnabled by viewModel.analyticsEnabled.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Settings") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            item {
                SettingCategory("Appearance") {
                    SettingItem("Theme", appTheme) { navController.navigate(PulesDestinations.APPEARANCE_SETTINGS_ROUTE) }
                    SettingItem("Font Size", fontSize) { navController.navigate(PulesDestinations.APPEARANCE_SETTINGS_ROUTE) }
                    SettingItem("Primary Color", primaryColor) { navController.navigate(PulesDestinations.APPEARANCE_SETTINGS_ROUTE) }
                }
            }
            item {
                SettingCategory("Language") {
                    SettingItem("App Language", appLanguage) { navController.navigate(PulesDestinations.LANGUAGE_SETTINGS_ROUTE) }
                }
            }
            item {
                SettingCategory("Notifications") {
                    SettingItem("Enable Notifications", if (notificationsEnabled) "On" else "Off") { navController.navigate(PulesDestinations.NOTIFICATIONS_SETTINGS_ROUTE) }
                    SettingItem("Notification Type", notificationType) { navController.navigate(PulesDestinations.NOTIFICATIONS_SETTINGS_ROUTE) }
                    SettingItem("Check Schedule", notificationSchedule) { navController.navigate(PulesDestinations.NOTIFICATIONS_SETTINGS_ROUTE) }
                }
            }
            item {
                SettingCategory("API Keys") {
                    SettingItem("YouTube API Key", if (youtubeApiKey.isNullOrBlank()) "Not set" else "Set") { navController.navigate(PulesDestinations.API_KEYS_SETTINGS_ROUTE) }
                    SettingItem("Twitter Bearer Token", if (twitterBearerToken.isNullOrBlank()) "Not set" else "Set") { navController.navigate(PulesDestinations.API_KEYS_SETTINGS_ROUTE) }
                }
            }
            item {
                SettingCategory("Backup & Restore") {
                    SettingItem("Backup Data", "Local JSON") { navController.navigate(PulesDestinations.BACKUP_SETTINGS_ROUTE) }
                    SettingItem("Restore Data", "From local JSON") { navController.navigate(PulesDestinations.BACKUP_SETTINGS_ROUTE) }
                }
            }
            item {
                SettingCategory("Privacy") {
                    SettingItem("Analytics & Tracking", if (analyticsEnabled) "Enabled" else "Disabled") { navController.navigate(PulesDestinations.PRIVACY_SETTINGS_ROUTE) }
                }
            }
        }
    }
}

@Composable
fun SettingCategory(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        content()
    }
}

@Composable
fun SettingItem(title: String, subtitle: String, onClick: () -> Unit) {
    ListItem(
        modifier = Modifier.clickable(onClick = onClick),
        headlineContent = { Text(title) },
        supportingContent = { Text(subtitle) },
        trailingContent = { Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null) }
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    PulesTheme {
        SettingsScreen(rememberNavController())
    }
}


