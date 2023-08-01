package com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations

import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun AnimationTargetBasedAnimationScreen() {
    var state by remember { mutableStateOf(false) }
    val animation = remember {
        TargetBasedAnimation(
            animationSpec = tween(durationMillis = 2_000),
            typeConverter = Float.VectorConverter,
            initialValue = 100f,
            targetValue = 300f
        )
    }
    var playTime by remember { mutableStateOf(0L) }
    var animationValue by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = state) {
        val startTime = withFrameNanos { it }
        do {
            playTime = withFrameNanos { it } - startTime
            animationValue = animation.getValueFromNanos(playTime).toInt()
        } while (!animation.isFinishedFromNanos(playTime))
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.animation_target_based_animation),
            textAlign = TextAlign.Center
        )

        Image(
            modifier = Modifier.size(animationValue.dp),
            painter = painterResource(id = R.drawable.vd_cast_green_mono_1_128x128_rounded_corner),
            contentDescription = "animated_visibility_1"
        )

        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { state = !state }
        ) { Text(text = stringResource(id = R.string.start_animation)) }
    }
}