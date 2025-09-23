package com.pules.app.ui.screens.settings.appearance

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
fun AppearanceSettings(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val appTheme by viewModel.appTheme.collectAsState()
    val fontSize by viewModel.fontSize.collectAsState()
    val primaryColor by viewModel.primaryColor.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Appearance") },
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
            ListItem(
                modifier = Modifier.fillMaxWidth().clickable { /* Handle theme selection */ },
                headlineContent = { Text("Theme") },
                supportingContent = { Text(appTheme) }
            )
            ListItem(
                modifier = Modifier.fillMaxWidth().clickable { /* Handle font size selection */ },
                headlineContent = { Text("Font Size") },
                supportingContent = { Text(fontSize) }
            )
            ListItem(
                modifier = Modifier.fillMaxWidth().clickable { /* Handle color selection */ },
                headlineContent = { Text("Primary Color") },
                supportingContent = { Text(primaryColor) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppearanceSettingsPreview() {
    PulesTheme {
        AppearanceSettings(rememberNavController())
    }
}


