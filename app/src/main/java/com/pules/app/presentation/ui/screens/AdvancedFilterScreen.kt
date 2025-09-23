package com.pules.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.viewmodel.SettingsViewModel
import com.pules.app.ui.components.SettingItem
import com.pules.app.ui.components.SettingItemCard
import com.pules.app.ui.components.SelectionDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedFilterScreen(navController: NavController, viewModel: SettingsViewModel = hiltViewModel()) {
    val filterByTime by viewModel.filterByTime.collectAsState()
    val filterByCategory by viewModel.filterByCategory.collectAsState()
    val filterByLength by viewModel.filterByLength.collectAsState()

    var showTimeDialog by remember { mutableStateOf(false) }
    var showCategoryDialog by remember { mutableStateOf(false) }
    var showLengthDialog by remember { mutableStateOf(false) }

    val timeOptions = listOf("Any", "Last Hour", "Last Day", "Last Week", "Last Month")
    val categoryOptions = listOf("All", "Technology", "Politics", "Sports", "Business", "Science", "Health", "Entertainment", "World News", "General")
    val lengthOptions = listOf("Any", "Short (<5 min)", "Medium (5-15 min)", "Long (>15 min)")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("إعدادات التصفية المتقدمة") },
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
                    setting = SettingItem("التصفية حسب الوقت", filterByTime, Icons.Default.Timer),
                    onClick = { showTimeDialog = true }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("التصفية حسب الفئة", filterByCategory, Icons.Default.Category),
                    onClick = { showCategoryDialog = true }
                )
            }
            item {
                SettingItemCard(
                    setting = SettingItem("التصفية حسب الطول", filterByLength, Icons.Default.HourglassEmpty),
                    onClick = { showLengthDialog = true }
                )
            }
        }

        if (showTimeDialog) {
            SelectionDialog(
                title = "تصفية حسب الوقت",
                options = timeOptions,
                currentSelection = filterByTime,
                onDismiss = { showTimeDialog = false },
                onOptionSelected = { time ->
                    viewModel.saveFilterByTime(time)
                    showTimeDialog = false
                }
            )
        }

        if (showCategoryDialog) {
            SelectionDialog(
                title = "تصفية حسب الفئة",
                options = categoryOptions,
                currentSelection = filterByCategory,
                onDismiss = { showCategoryDialog = false },
                onOptionSelected = { category ->
                    viewModel.saveFilterByCategory(category)
                    showCategoryDialog = false
                }
            )
        }

        if (showLengthDialog) {
            SelectionDialog(
                title = "تصفية حسب الطول",
                options = lengthOptions,
                currentSelection = filterByLength,
                onDismiss = { showLengthDialog = false },
                onOptionSelected = { length ->
                    viewModel.saveFilterByLength(length)
                    showLengthDialog = false
                }
            )
        }
    }
}


