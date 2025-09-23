package com.pules.app.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.unit.dp

@Composable
fun InteractiveButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(12.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(
        defaultElevation = 4.dp,
        pressedElevation = 8.dp,
        disabledElevation = 0.dp
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enableHapticFeedback: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    val hapticFeedback = rememberHapticFeedback()
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = tween(100)
    )
    
    val containerColor by animateColorAsState(
        targetValue = if (isPressed) 
            colors.containerColor.copy(alpha = 0.8f) 
        else 
            colors.containerColor,
        animationSpec = tween(100)
    )
    
    LaunchedEffect(isPressed) {
        if (isPressed && enableHapticFeedback) {
            HapticFeedbackHelper.performHapticFeedback(
                hapticFeedback, 
                HapticFeedbackType.LongPress
            )
        }
    }
    
    Button(
        onClick = {
            if (enableHapticFeedback) {
                HapticFeedbackHelper.performHapticFeedback(
                    hapticFeedback, 
                    HapticFeedbackType.LongPress
                )
            }
            onClick()
        },
        modifier = modifier.scale(scale),
        enabled = enabled,
        shape = shape,
        colors = colors.copy(containerColor = containerColor),
        elevation = elevation,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

