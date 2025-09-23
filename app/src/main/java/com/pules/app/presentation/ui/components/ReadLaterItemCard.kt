package com.pules.app.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pules.app.Screen
import com.pules.app.domain.model.ReadLaterItem
import com.pules.app.ui.viewmodel.ReadLaterViewModel

@Composable
fun ReadLaterItemCard(item: ReadLaterItem, onDelete: () -> Unit, navController: NavController) {
    val viewModel: ReadLaterViewModel = hiltViewModel()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                item.content?.let {
                    navController.navigate(Screen.ReadingMode.createRoute(it, item.id))
                }
            },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                Text(text = item.url, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            // IconButton(onClick = onDelete) {
            //     Icon(Icons.Default.Delete, contentDescription = "حذف من قائمة القراءة لاحقًا")
            // }
        }
    }
}


