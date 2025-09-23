package com.pules.app

import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.TextDecrease
import androidx.compose.material.icons.filled.TextIncrease
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.Locale
import com.pules.app.ui.components.FontSelectionDialog
import androidx.compose.material.icons.filled.FontDownload
import androidx.compose.material.icons.filled.WifiOff

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingModeScreen(navController: NavController, articleContent: String, articleId: String) {
    var fontSize by remember { mutableStateOf(16.sp) }
    var showFontDialog by remember { mutableStateOf(false) }
    var selectedFont by remember { mutableStateOf("Default") }
    val isOffline by remember { mutableStateOf(false) } // This should be a real state
    val context = LocalContext.current
    var tts: TextToSpeech? by remember { mutableStateOf(null) }

    DisposableEffect(Unit) {
        tts = TextToSpeech(context) {
            if (it == TextToSpeech.SUCCESS) {
                tts?.language = Locale.getDefault()
            }
        }
        onDispose { tts?.shutdown() }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("وضع القراءة") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "العودة")
                    }
                },
                actions = {
                    IconButton(onClick = { fontSize = (fontSize.value - 2).sp }) {
                        Icon(Icons.Default.TextDecrease, contentDescription = "تصغير الخط")
                    }
                    IconButton(onClick = { fontSize = (fontSize.value + 2).sp }) {
                        Icon(Icons.Default.TextIncrease, contentDescription = "تكبير الخط")
                    }
                    IconButton(onClick = { tts?.speak(articleContent, TextToSpeech.QUEUE_FLUSH, null, "") }) {
                        Icon(Icons.Default.VolumeUp, contentDescription = "قراءة بصوت عالٍ")
                    }
                    IconButton(onClick = { showFontDialog = true }) {
                        Icon(Icons.Default.FontDownload, contentDescription = "تغيير الخط")
                    }
                    IconButton(onClick = { /* TODO: Implement offline mode toggle */ }) {
                        Icon(Icons.Default.WifiOff, contentDescription = "وضع عدم الاتصال")
                    }
                    IconButton(onClick = { shareArticle(context, articleContent) }) {
                        Icon(Icons.Default.Share, contentDescription = "مشاركة المقال")
                    }
                    IconButton(onClick = { navController.navigate(Screen.Notes.createRoute(articleId)) }) {
                        Icon(Icons.Default.Notes, contentDescription = "الملاحظات")
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
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .verticalScroll(rememberScrollState())
                .pointerInput(Unit) {
                    detectTransformGestures {
                        _, _, zoom, _ ->
                        fontSize = (fontSize.value * zoom).sp.coerceIn(12.sp, 32.sp)
                    }
                }
        ) {
            Text(
                text = articleContent,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = fontSize),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.semantics { liveRegion = LiveRegionMode.Polite }
            )
        }
    }
}

private fun shareArticle(context: Context, content: String) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, content)
        type = "text/plain"
    }
    context.startActivity(Intent.createChooser(shareIntent, "مشاركة المقال عبر"))
}




        if (showFontDialog) {
            FontSelectionDialog(
                currentFont = selectedFont,
                onDismiss = { showFontDialog = false },
                onFontSelected = { font ->
                    selectedFont = font
                    showFontDialog = false
                }
            )
        }


