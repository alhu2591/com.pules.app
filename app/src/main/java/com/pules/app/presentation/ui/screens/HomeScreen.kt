package com.pules.app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Recommend
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.viewmodel.HomeViewModel
import com.pules.app.ui.viewmodel.RecommendationsViewModel
import com.pules.app.ui.components.MenuItemCard
import com.pules.app.ui.components.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel(), mainViewModel: MainViewModel = hiltViewModel(), recommendationsViewModel: RecommendationsViewModel = hiltViewModel()) {
    val sources by homeViewModel.sources.collectAsState()
    val themePreference by mainViewModel.themePreference.collectAsState()
    val recommendedArticles by recommendationsViewModel.recommendedArticles.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("تطبيق Pules") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Search.route)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "بحث"
                        )
                    }
                    IconButton(onClick = {
                        val newTheme = if (themePreference == "dark") "light" else "dark"
                        mainViewModel.saveThemePreference(newTheme)
                    }) {
                        Icon(
                            imageVector = if (themePreference == "dark") Icons.Default.LightMode else Icons.Default.DarkMode,
                            contentDescription = if (themePreference == "dark") "Light Mode" else "Dark Mode"
                        )
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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "مرحباً بك في تطبيق Pules",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "تطبيق شامل لإدارة المهام والملفات مع دعم النسخ الاحتياطي والإشعارات",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            item {
                Text(
                    text = "المصادر المتابعة",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            if (sources.isEmpty()) {
                item {
                    com.pules.app.ui.components.EmptyStateCard(
                        icon = Icons.Default.RssFeed,
                        title = "لا توجد مصادر متابعة",
                        description = "أضف مصادرك المفضلة لتتابع آخر الأخبار والمقالات من مكان واحد",
                        actionText = "إضافة مصدر",
                        onActionClick = { navController.navigate(Screen.Sources.route) }
                    )
                }
            } else {
                items(sources) {
                    com.pules.app.ui.components.SourceItem(source = it) { /* No delete action on home screen */ }
                }
            }

            item {
                Text(
                    text = "مقالات مقترحة لك",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            if (recommendedArticles.isEmpty()) {
                item {
                    com.pules.app.ui.components.EmptyStateCard(
                        icon = Icons.Default.Recommend,
                        title = "لا توجد توصيات حاليًا",
                        description = "تفاعل مع المحتوى وأضف مصادر لترى توصيات مخصصة لك هنا",
                        actionText = "استكشف المصادر",
                        onActionClick = { navController.navigate(Screen.Sources.route) }
                    )
                }
            } else {
                items(recommendedArticles) {
                    Text(text = it) // Display recommended article titles
                }
            }


        }
    }
}


