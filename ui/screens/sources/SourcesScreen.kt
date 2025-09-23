package com.pules.app.ui.screens.sources

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.components.SourceCard
import com.pules.app.ui.theme.PulesTheme
import com.pules.app.viewmodel.SourcesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SourcesScreen(
    viewModel: SourcesViewModel = hiltViewModel()
) {
    val sources by viewModel.sources.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    var showAddSourceDialog by remember { mutableStateOf(false) }
    var newSourceUrl by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Manage Sources") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddSourceDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add Source")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isLoading) {
                Text("Loading sources...")
            }
            error?.let { errorMessage ->
                Text("Error: $errorMessage", color = MaterialTheme.colorScheme.error)
            }

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(sources) {
                    source ->
                    SourceCard(source = source, onClick = { /* Handle source click */ }, modifier = Modifier.padding(8.dp))
                }
            }
        }

        if (showAddSourceDialog) {
            AlertDialog(
                onDismissRequest = { showAddSourceDialog = false },
                title = { Text("Add New Source") },
                text = {
                    Column {
                        Text("Enter YouTube channel URL or Twitter profile URL:")
                        OutlinedTextField(
                            value = newSourceUrl,
                            onValueChange = { newSourceUrl = it },
                            label = { Text("Source URL") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            if (newSourceUrl.isNotBlank()) {
                                viewModel.addSource(newSourceUrl)
                                newSourceUrl = ""
                                showAddSourceDialog = false
                            }
                        }
                    ) {
                        Text("Add")
                    }
                },
                dismissButton = {
                    Button(onClick = { showAddSourceDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SourcesScreenPreview() {
    PulesTheme {
        SourcesScreen()
    }
}


