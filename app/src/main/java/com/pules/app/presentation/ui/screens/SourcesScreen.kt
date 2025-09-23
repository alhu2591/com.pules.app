package com.pules.app

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.pules.app.domain.model.Source
import com.pules.app.ui.components.SourceItem
import com.pules.app.ui.components.AddSourceDialog
import com.pules.app.ui.viewmodel.SourcesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SourcesScreen(navController: NavController, viewModel: SourcesViewModel = hiltViewModel()) {
    val sources by viewModel.sources.collectAsState()
    var showAddSourceDialog by remember { mutableStateOf(false) }
    var fetchedChannelName by remember { mutableStateOf<String?>(null) }
    var fetchedChannelImageUrl by remember { mutableStateOf<String?>(null) }
    var fetchedSubscriberCount by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("المصادر") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "العودة")
                    }
                },
                actions = {
                    IconButton(onClick = { showAddSourceDialog = true }) {
                        Icon(Icons.Default.Add, contentDescription = "إضافة مصدر")
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
            Text(
                text = "قائمة المصادر المتابعة",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            if (sources.isEmpty()) {
                com.pules.app.ui.components.EmptyStateCard(
                    icon = Icons.Default.RssFeed,
                    title = "لا توجد مصادر متابعة",
                    description = "ابدأ بإضافة مصادرك المفضلة لتتابع آخر الأخبار والمقالات",
                    actionText = "إضافة مصدر",
                    onActionClick = { showAddSourceDialog = true }
                )
            } else {
                LazyColumn {
                    items(sources, key = { it.id }) {
                        val dismissState = rememberDismissState(
                            confirmValueChange = {
                                if (it == DismissValue.DismissedToStart) {
                                    viewModel.removeSource(it.id)
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "تم حذف المصدر: ${it.name}",
                                            actionLabel = "تراجع"
                                        )
                                    }
                                    true
                                } else false
                            }
                        )

                        SwipeToDismiss(
                            state = dismissState,
                            background = {
                                val color by animateColorAsState(
                                    when (dismissState.targetValue) {
                                        DismissValue.Default -> Color.LightGray
                                        DismissValue.DismissedToEnd -> Color.Green // Not used for now
                                        DismissValue.DismissedToStart -> Color.Red
                                    }
                                )
                                val scale by animateFloatAsState(if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f)

                                Box(
                                    Modifier
                                        .fillMaxSize()
                                        .background(color)
                                        .padding(horizontal = 20.dp),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Icon(
                                        Icons.Default.Delete,
                                        contentDescription = "حذف المصدر",
                                        modifier = Modifier.scale(scale)
                                    )
                                }
                            },
                            dismissContent = {
                                com.pules.app.ui.components.SourceItem(source = it) { navController.navigate(Screen.SourceDetail.createRoute(it.id)) }
                            }
                        )
                    }
                }
            }
        }

        if (showAddSourceDialog) {
            com.pules.app.ui.components.AddSourceDialog(
                onDismiss = { showAddSourceDialog = false },
                onAddSource = { name, url, category, channelName, channelImageUrl, subscriberCount ->
                    viewModel.addSource(Source(id = name, name = name, url = url, description = null, imageUrl = channelImageUrl, category = category, language = null, country = null, isFollowed = true, channelName = channelName, subscriberCount = subscriberCount))
                    showAddSourceDialog = false
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "تم إضافة المصدر: $name"
                        )
                    }
                    // Reset fetched channel info
                    fetchedChannelName = null
                    fetchedChannelImageUrl = null
                    fetchedSubscriberCount = null
                },
                onCheckSourceUrl = { url ->
                    scope.launch {
                        val (name, imageUrl, subscribers) = viewModel.checkSourceUrl(url)
                        fetchedChannelName = name
                        fetchedChannelImageUrl = imageUrl
                        fetchedSubscriberCount = subscribers
                    }
                },
                channelName = fetchedChannelName,
                channelImageUrl = fetchedChannelImageUrl,
                subscriberCount = fetchedSubscriberCount
            )

        }
    }
}






