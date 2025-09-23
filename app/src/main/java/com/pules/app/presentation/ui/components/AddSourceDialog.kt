package com.pules.app.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSourceDialog(
    onDismiss: () -> Unit,
    onAddSource: (String, String, String?, String?, String?, String?) -> Unit,
    onCheckSourceUrl: (String) -> Unit,
    channelName: String?,
    channelImageUrl: String?,
    subscriberCount: String?
) {
    var sourceName by remember { mutableStateOf("") }
    var sourceUrl by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    var expanded by remember { mutableStateOf(false) }

    val categories = listOf("تقنية", "سياسة", "رياضة", "اقتصاد", "صحة", "متنوع")

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("إضافة مصدر جديد") },
        text = {
            Column {
                OutlinedTextField(
                    value = sourceName,
                    onValueChange = { sourceName = it },
                    label = { Text("اسم المصدر") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = sourceUrl,
                    onValueChange = { newUrl ->
                        sourceUrl = newUrl
                        // Trigger check after a short delay or when focus is lost
                        // For now, we'll just call it directly for demonstration
                        if (newUrl.isNotBlank()) {
                            onCheckSourceUrl(newUrl)
                        }
                    },
                    label = { Text("رابط المصدر") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Display fetched channel information
                if (channelName != null) {
                    Text("اسم القناة: $channelName")
                    Spacer(modifier = Modifier.height(4.dp))
                }
                if (subscriberCount != null) {
                    Text("عدد المشتركين: $subscriberCount")
                    Spacer(modifier = Modifier.height(4.dp))
                }
                if (channelImageUrl != null) {
                    AsyncImage(
                        model = channelImageUrl,
                        contentDescription = "صورة القناة",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(MaterialTheme.shapes.small),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Spacer(modifier = Modifier.height(8.dp))
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = selectedCategory ?: "اختر تصنيفًا",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("التصنيف") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        categories.forEach { category ->
                            DropdownMenuItem(
                                text = { Text(category) },
                                onClick = {
                                    selectedCategory = category
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { onAddSource(sourceName, sourceUrl, selectedCategory, channelName, channelImageUrl, subscriberCount) },
                enabled = sourceName.isNotBlank() && sourceUrl.isNotBlank()
            ) {
                Text("إضافة")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("إلغاء")
            }
        }
    )
}


