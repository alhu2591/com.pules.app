package com.pules.app

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pules.app.ui.components.SettingToggleItem
import com.pules.app.ui.components.SettingToggleItemCard
import com.pules.app.ui.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessibilitySettingsScreen(navController: NavController, viewModel: SettingsViewModel = hiltViewModel()) {
    val highContrastMode by viewModel.highContrastMode.collectAsState()
    val speechRate by viewModel.speechRate.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("إعدادات إمكانية الوصول") },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            SettingToggleItemCard(
                setting = SettingToggleItem("وضع التباين العالي", highContrastMode),
                onToggle = { viewModel.saveHighContrastMode(it) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("سرعة تحويل النص إلى كلام", style = MaterialTheme.typography.titleMedium)
            Slider(
                value = speechRate,
                onValueChange = { viewModel.saveSpeechRate(it) },
                valueRange = 0.5f..2.0f,
                steps = 15,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = "${(speechRate * 100).toInt()}%", style = MaterialTheme.typography.bodySmall)
        }
    }
}

