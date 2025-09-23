package com.pules.app.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApiKeyDialog(
    service: String,
    currentApiKey: String?,
    onDismiss: () -> Unit,
    onSaveApiKey: (String, String) -> Unit,
    onGetApiKeyOptions: List<Pair<String, String>>,
    onGetApiKey: (String) -> Unit
) {
    var newApiKey by remember { mutableStateOf(currentApiKey ?: "") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("إدخال مفتاح API لـ ${service.replace("_", " ").capitalize()}") },
        text = {
            Column {
                OutlinedTextField(
                    value = newApiKey,
                    onValueChange = { newApiKey = it },
                    label = { Text("مفتاح API") },
                    singleLine = true,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text("أدخل مفتاح API الخاص بك هنا.")
            }
        },
        confirmButton = {
            Button(onClick = { onSaveApiKey(service, newApiKey) }) {
                Text("حفظ")
            }

            Spacer(Modifier.padding(horizontal = 4.dp))
            // Display dynamic 'Get API Key' options
            onGetApiKeyOptions.forEach { (label, url) ->
                Button(onClick = { onGetApiKey(url) }) {
                    Text(label)
                }
                Spacer(Modifier.padding(horizontal = 4.dp))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("إلغاء")
            }
        }
    )
}


