package com.pules.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Backup
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Lock
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
import android.content.Intent
import android.net.Uri
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedSettingsScreen(navController: NavController, viewModel: SettingsViewModel = hiltViewModel()) {
    var showApiKeyDialog by remember { mutableStateOf(false) }
    var selectedService by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("إعدادات متقدمة") },
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
                    setting = SettingItem("مفتاح API (News API)", viewModel.getApiKey("news_api").collectAsState(initial = null).value ?: "غير محدد", Icons.Default.Security),
                    onClick = { showApiKeyDialog = true; selectedService = "news_api" }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("مفتاح API (YouTube)", viewModel.getApiKey("youtube").collectAsState(initial = null).value ?: "غير محدد", Icons.Default.Security),
                    onClick = { showApiKeyDialog = true; selectedService = "youtube" }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("مفتاح API (Twitter)", viewModel.getApiKey("twitter").collectAsState(initial = null).value ?: "غير محدد", Icons.Default.Security),
                    onClick = { showApiKeyDialog = true; selectedService = "twitter" }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("مفتاح API (Facebook)", viewModel.getApiKey("facebook").collectAsState(initial = null).value ?: "غير محدد", Icons.Default.Security),
                    onClick = { showApiKeyDialog = true; selectedService = "facebook" }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("مفتاح API (Instagram)", viewModel.getApiKey("instagram").collectAsState(initial = null).value ?: "غير محدد", Icons.Default.Security),
                    onClick = { showApiKeyDialog = true; selectedService = "instagram" }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("مفتاح API (TikTok)", viewModel.getApiKey("tiktok").collectAsState(initial = null).value ?: "غير محدد", Icons.Default.Security),
                    onClick = { showApiKeyDialog = true; selectedService = "tiktok" }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("قفل التطبيق", "إدارة خيارات قفل التطبيق", Icons.Default.Lock),
                    onClick = { navController.navigate(Screen.AppLockSettings.route) }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("النسخ الاحتياطي", "إدارة النسخ الاحتياطي", Icons.Default.Backup),
                    onClick = { /* TODO: Navigate to backup screen */ }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("التخزين", "إدارة التخزين", Icons.Default.Storage),
                    onClick = { /* TODO: Navigate to storage screen */ }
                )
            }
        }

        if (showApiKeyDialog) {
            ApiKeyDialog(
                service = selectedService,
                currentApiKey = viewModel.getApiKey(selectedService).collectAsState(initial = null).value,
                onDismiss = { showApiKeyDialog = false },
                onSaveApiKey = { service, key ->
                    viewModel.saveApiKey(service, key)
                    showApiKeyDialog = false
                },

                onGetApiKeyOptions = when (selectedService) {
                    "youtube" -> listOf(
                        Pair("YouTube API Console", "https://console.developers.google.com/apis/credentials")
                    )
                    "twitter" -> listOf(
                        Pair("Twitter Developer Portal", "https://developer.twitter.com/en/portal/projects-and-apps")
                    )
                    "news_api" -> listOf(
                        Pair("News API Account", "https://newsapi.org/account")
                    )
                    "facebook" -> listOf(
                        Pair("Meta for Developers", "https://developers.facebook.com/apps/")
                    )
                    "instagram" -> listOf(
                        Pair("Meta for Developers", "https://developers.facebook.com/apps/")
                    )
                    "tiktok" -> listOf(
                        Pair("TikTok for Developers", "https://developers.tiktok.com/")
                    )
                    else -> emptyList()
                },
                onGetApiKey = { url ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    navController.context.startActivity(intent)
                }
            )
        }
    }
}


