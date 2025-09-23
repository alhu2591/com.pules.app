package com.pules.app.ui.screens.settings.notifications

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
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
import com.pules.app.ui.theme.PulesTheme
import com.pules.app.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsSettings(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val notificationsEnabled by viewModel.notificationsEnabled.collectAsState()
    val notificationType by viewModel.notificationType.collectAsState()
    val notificationSchedule by viewModel.notificationSchedule.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifications") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().clickable { viewModel.setNotificationsEnabled(!notificationsEnabled) },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Enable Notifications", modifier = Modifier.weight(1f))
                Switch(
                    checked = notificationsEnabled,
                    onCheckedChange = { viewModel.setNotificationsEnabled(it) }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            ListItem(
                modifier = Modifier.fillMaxWidth().clickable { /* Handle notification type selection */ },
                headlineContent = { Text("Notification Type") },
                supportingContent = { Text(notificationType) }
            )
            ListItem(
                modifier = Modifier.fillMaxWidth().clickable { /* Handle notification schedule selection */ },
                headlineContent = { Text("Check Schedule") },
                supportingContent = { Text(notificationSchedule) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationsSettingsPreview() {
    PulesTheme {
        NotificationsSettings(rememberNavController())
    }
}


