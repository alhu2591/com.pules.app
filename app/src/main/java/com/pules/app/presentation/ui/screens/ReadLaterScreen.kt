package com.pules.app

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.domain.model.ReadLaterItem
import com.pules.app.ui.components.ReadLaterItemCard
import com.pules.app.ui.viewmodel.ReadLaterViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadLaterScreen(navController: NavController, viewModel: ReadLaterViewModel = hiltViewModel()) {
    val readLaterItems by viewModel.readLaterItems.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("قراءة لاحقًا") },
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
            Text(
                text = "قائمة العناصر المحفوظة للقراءة لاحقًا",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            if (readLaterItems.isEmpty()) {
                com.pules.app.ui.components.EmptyStateCard(
                    icon = Icons.Default.Bookmark,
                    title = "لا توجد عناصر للقراءة لاحقًا",
                    description = "احفظ المقالات والمحتوى المهم للقراءة في وقت لاحق عندما يكون لديك وقت أكثر",
                    actionText = "استكشف المحتوى",
                    onActionClick = { navController.navigate(Screen.Home.route) }
                )
            } else {
                LazyColumn {
                    items(readLaterItems, key = { it.id }) {
                        val dismissState = rememberDismissState(
                            confirmValueChange = {
                                if (it == DismissValue.DismissedToStart) {
                                    viewModel.removeReadLaterItem(it.id)
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "تم حذف العنصر من قائمة القراءة لاحقًا: ${it.title}",
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
                                        contentDescription = "حذف من قائمة القراءة لاحقًا",
                                        modifier = Modifier.scale(scale)
                                    )
                                }
                            },
                            dismissContent = {
                                com.pules.app.ui.components.ReadLaterItemCard(item = it, navController = navController) {
                                    viewModel.removeReadLaterItem(it.id)
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "تم حذف العنصر من قائمة القراءة لاحقًا: ${it.title}",
                                            actionLabel = "تراجع"
                                        )
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}





