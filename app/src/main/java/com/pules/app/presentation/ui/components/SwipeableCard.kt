package com.pules.app.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Composable
fun SwipeableCard(
    modifier: Modifier = Modifier,
    onSwipeLeft: (() -> Unit)? = null,
    onSwipeRight: (() -> Unit)? = null,
    leftIcon: ImageVector = Icons.Default.Delete,
    rightIcon: ImageVector = Icons.Default.Favorite,
    leftColor: Color = Color.Red,
    rightColor: Color = Color.Green,
    swipeThreshold: Float = 0.3f,
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current
    var offsetX by remember { mutableStateOf(0f) }
    var isDragging by remember { mutableStateOf(false) }
    
    val animatedOffsetX by animateFloatAsState(
        targetValue = if (isDragging) offsetX else 0f,
        animationSpec = tween(300),
        finishedListener = {
            if (!isDragging) offsetX = 0f
        }
    )
    
    val swipeProgress = (animatedOffsetX.absoluteValue / with(density) { 100.dp.toPx() }).coerceIn(0f, 1f)
    
    val backgroundColor by animateColorAsState(
        targetValue = when {
            animatedOffsetX > 0 -> rightColor.copy(alpha = swipeProgress * 0.3f)
            animatedOffsetX < 0 -> leftColor.copy(alpha = swipeProgress * 0.3f)
            else -> Color.Transparent
        },
        animationSpec = tween(150)
    )
    
    val iconScale by animateFloatAsState(
        targetValue = if (swipeProgress > 0.1f) 1f + (swipeProgress * 0.3f) else 0.8f,
        animationSpec = tween(150)
    )
    
    Box(modifier = modifier) {
        // Background with action icons
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = if (animatedOffsetX > 0) Alignment.CenterStart else Alignment.CenterEnd
            ) {
                if (swipeProgress > 0.1f) {
                    Icon(
                        imageVector = if (animatedOffsetX > 0) rightIcon else leftIcon,
                        contentDescription = null,
                        tint = if (animatedOffsetX > 0) rightColor else leftColor,
                        modifier = Modifier
                            .scale(iconScale)
                            .padding(horizontal = 20.dp)
                    )
                }
            }
        }
        
        // Main content card
        Card(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(animatedOffsetX.roundToInt(), 0) }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragStart = { isDragging = true },
                        onDragEnd = {
                            val threshold = size.width * swipeThreshold
                            
                            when {
                                offsetX > threshold && onSwipeRight != null -> {
                                    onSwipeRight()
                                }
                                offsetX < -threshold && onSwipeLeft != null -> {
                                    onSwipeLeft()
                                }
                            }
                            
                            isDragging = false
                        },
                        onHorizontalDrag = { _, dragAmount ->
                            val newOffset = offsetX + dragAmount
                            val maxOffset = size.width * 0.4f
                            
                            offsetX = when {
                                newOffset > 0 && onSwipeRight != null -> newOffset.coerceAtMost(maxOffset)
                                newOffset < 0 && onSwipeLeft != null -> newOffset.coerceAtLeast(-maxOffset)
                                else -> 0f
                            }
                        }
                    )
                },
            elevation = CardDefaults.cardElevation(
                defaultElevation = if (swipeProgress > 0.1f) 8.dp else 2.dp
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            content()
        }
    }
}

