package com.pules.app.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FontSelectionDialog(
    currentFont: String,
    onDismiss: () -> Unit,
    onFontSelected: (String) -> Unit
) {
    val fontOptions = listOf("Default", "Serif", "Sans-serif", "Monospace")

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("اختيار الخط") },
        text = {
            LazyColumn {
                items(fontOptions) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onFontSelected(it) }
                            .padding(16.dp)
                    ) {
                        RadioButton(
                            selected = (it == currentFont),
                            onClick = { onFontSelected(it) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(it)
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("إلغاء")
            }
        }
    )
}


