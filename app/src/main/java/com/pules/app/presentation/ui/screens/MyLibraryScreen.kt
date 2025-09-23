package com.pules.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.pules.app.ui.components.MenuItem
import com.pules.app.ui.components.MenuItemCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLibraryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("مكتبتي") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val menuItems = listOf(
                MenuItem("المفضلة", Icons.Default.Favorite, Screen.Favorites.route),
                MenuItem("قراءة لاحقًا", Icons.Default.Star, Screen.ReadLater.route)
            )

            menuItems.forEach { item ->
                MenuItemCard(item = item) {
                    navController.navigate(item.route)
                }
            }
        }
    }
}


