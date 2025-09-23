package com.pules.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.viewmodel.SettingsViewModel
import com.pules.app.ui.components.SettingToggleItemCard
import com.pules.app.ui.components.SettingItemCard
import com.pules.app.ui.components.SettingItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationSettingsScreen(navController: NavController, viewModel: SettingsViewModel = hiltViewModel()) {
    val notificationPreference by viewModel.notificationPreference.collectAsState()
    val notificationFrequency by viewModel.notificationFrequency.collectAsState()
    val preferredSourcesForNotifications by viewModel.preferredSourcesForNotifications.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("إعدادات الإشعارات") },
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
                SettingToggleItemCard(
                    setting = SettingToggleItem("تفعيل الإشعارات", notificationPreference, Icons.Default.NotificationsActive),
                    onToggle = { viewModel.saveNotificationPreference(it) }
                )
            }
            if (notificationPreference) {
                item {
                    SettingItemCard(
                        setting = SettingItem("تكرار الإشعارات", notificationFrequency, Icons.Default.NotificationsActive),
                        onClick = { /* TODO: Show frequency selection dialog */ }
                    )
                }
                item {
                    SettingItemCard(
                        setting = SettingItem("مصادر الإشعارات المفضلة", preferredSourcesForNotifications.joinToString(), Icons.Default.NotificationsActive),
                        onClick = { /* TODO: Show source selection dialog */ }
                    )
                }
            }
        }
    }
}


