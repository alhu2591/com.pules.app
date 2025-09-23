package com.pules.app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pules.app.domain.model.Note
import com.pules.app.ui.viewmodel.NotesViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(navController: NavController, articleId: String, viewModel: NotesViewModel = hiltViewModel()) {
    val notes by viewModel.getNotesForArticle(articleId).collectAsState(initial = emptyList())
    var showAddNoteDialog by remember { mutableStateOf(false) }
    var newNoteContent by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ملاحظاتي") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "العودة")
                    }
                },
                actions = {
                    IconButton(onClick = { showAddNoteDialog = true }) {
                        Icon(Icons.Default.Add, contentDescription = "إضافة ملاحظة")
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
            if (notes.isEmpty()) {
                Text("لا توجد ملاحظات لهذا المقال.", style = MaterialTheme.typography.bodyMedium)
            } else {
                LazyColumn {
                    items(notes, key = { it.id }) {
                        NoteCard(note = it, onDelete = { viewModel.deleteNote(it.id) })
                    }
                }
            }
        }

        if (showAddNoteDialog) {
            AlertDialog(
                onDismissRequest = { showAddNoteDialog = false },
                title = { Text("إضافة ملاحظة جديدة") },
                text = {
                    TextField(
                        value = newNoteContent,
                        onValueChange = { newNoteContent = it },
                        label = { Text("ملاحظتك") },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    Button(onClick = {
                        if (newNoteContent.isNotBlank()) {
                            viewModel.addNote(Note(articleId = articleId, noteContent = newNoteContent, timestamp = System.currentTimeMillis()))
                            newNoteContent = ""
                            showAddNoteDialog = false
                        }
                    }) { Text("إضافة") }
                },
                dismissButton = {
                    Button(onClick = { showAddNoteDialog = false }) { Text("إلغاء") }
                }
            )
        }
    }
}

@Composable
fun NoteCard(note: Note, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = note.noteContent, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date(note.timestamp)),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "حذف الملاحظة")
                }
            }
        }
    }
}


