package com.pules.app.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Source
import androidx.compose.ui.graphics.vector.ImageVector

sealed class PulesBottomNavItem(var title: String, var icon: ImageVector, var route: String) {
    object Home : PulesBottomNavItem("Home", Icons.Default.Home, PulesDestinations.HOME_ROUTE)
    object Favorites : PulesBottomNavItem("Favorites", Icons.Default.Favorite, PulesDestinations.FAVORITES_ROUTE)
    object ReadLater : PulesBottomNavItem("Read Later", Icons.Default.List, PulesDestinations.READ_LATER_ROUTE)
    object Sources : PulesBottomNavItem("Sources", Icons.Default.Source, PulesDestinations.SOURCES_ROUTE)
    object Settings : PulesBottomNavItem("Settings", Icons.Default.Settings, PulesDestinations.SETTINGS_ROUTE)
}


