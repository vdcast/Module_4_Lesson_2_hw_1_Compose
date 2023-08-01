package com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun AnimatableScreen() {
    var animated by remember { mutableStateOf(false) }
    val rotation = remember { Animatable(initialValue = 360f) }

    LaunchedEffect(key1 = animated) {
        rotation.animateTo(
            targetValue = if (animated) 0f else 360f,
            animationSpec = tween(durationMillis = 1000)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.animatable),
            textAlign = TextAlign.Center
        )

        Image(
            modifier = Modifier.graphicsLayer {
                rotationY = rotation.value
            },
            painter = painterResource(id = R.drawable.vd_cast_green_mono_1_128x128_rounded_corner),
            contentDescription = "animated_visibility_1"
        )

        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { animated = !animated }
        ) { Text(text = stringResource(id = R.string.rotate)) }
    }
}