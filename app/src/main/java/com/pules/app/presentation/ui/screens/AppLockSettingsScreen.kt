package com.pules.app

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.Role
import androidx.hilt.navigation.compose.hiltViewModel
import com.pules.app.ui.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLockSettingsScreen(navController: NavController, viewModel: SettingsViewModel = hiltViewModel()) {
    var appLockEnabled by remember { mutableStateOf(false) }
    var selectedLockType by remember { mutableStateOf("none") }
    var pinOrPassword by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("قفل التطبيق") },
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("تمكين قفل التطبيق", style = MaterialTheme.typography.titleMedium)
                Switch(
                    checked = appLockEnabled,
                    onCheckedChange = { appLockEnabled = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (appLockEnabled) {
                Text("نوع القفل", style = MaterialTheme.typography.titleSmall)
                Column(Modifier.selectableGroup()) {
                    LockTypeOption(
                        text = "بصمة الإصبع",
                        selected = selectedLockType == "fingerprint",
                        onClick = { selectedLockType = "fingerprint" }
                    )
                    LockTypeOption(
                        text = "رمز PIN",
                        selected = selectedLockType == "pin",
                        onClick = { selectedLockType = "pin" }
                    )
                    LockTypeOption(
                        text = "كلمة سر",
                        selected = selectedLockType == "password",
                        onClick = { selectedLockType = "password" }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (selectedLockType == "pin" || selectedLockType == "password") {
                    OutlinedTextField(
                        value = pinOrPassword,
                        onValueChange = { pinOrPassword = it },
                        label = { Text(if (selectedLockType == "pin") "أدخل رمز PIN" else "أدخل كلمة السر") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { /* TODO: Save PIN/Password */ }) {
                        Text("حفظ")
                    }
                }
            }
        }
    }
}

@Composable
fun LockTypeOption(text: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.RadioButton
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null // null recommended for accessibility with screenreaders
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


