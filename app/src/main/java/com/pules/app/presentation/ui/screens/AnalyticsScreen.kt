package com.pules.app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pules.app.ui.viewmodel.AnalyticsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyticsScreen(navController: NavController, viewModel: AnalyticsViewModel = hiltViewModel()) {
    val totalFavorites by viewModel.totalFavorites.collectAsState()
    val totalReadLaterItems by viewModel.totalReadLaterItems.collectAsState()
    val totalSources by viewModel.totalSources.collectAsState()
    val favoriteCategories by viewModel.favoriteCategories.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("تحليلاتي") },
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                AnalyticsCard(
                    title = "إجمالي المفضلة",
                    value = totalFavorites.toString(),
                    icon = Icons.Default.Favorite
                )
            }
            item {
                AnalyticsCard(
                    title = "إجمالي للقراءة لاحقًا",
                    value = totalReadLaterItems.toString(),
                    icon = Icons.Default.Star
                )
            }
            item {
                AnalyticsCard(
                    title = "إجمالي المصادر",
                    value = totalSources.toString(),
                    icon = Icons.Default.List
                )
            }
            item {
                Text(
                    text = "الفئات المفضلة",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                if (favoriteCategories.isEmpty()) {
                    Text("لا توجد فئات مفضلة بعد.")
                } else {
                    favoriteCategories.forEach { (category, count) ->
                        Text("- $category: $count", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }
}

@Composable
fun AnalyticsCard(title: String, value: String, icon: ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = title, modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = title, style = MaterialTheme.typography.titleLarge)
            }
            Text(text = value, style = MaterialTheme.typography.headlineMedium)
        }
    }
}


