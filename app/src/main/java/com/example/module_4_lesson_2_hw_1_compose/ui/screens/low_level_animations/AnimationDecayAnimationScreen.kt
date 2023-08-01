package com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations

import androidx.compose.animation.core.DecayAnimation
import androidx.compose.animation.core.FloatExponentialDecaySpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun AnimationDecayAnimationScreen() {
    var state by remember { mutableStateOf(false) }
    val animation = remember {
        DecayAnimation(
            animationSpec = FloatExponentialDecaySpec(frictionMultiplier = 0.7f),
            initialValue = 0f,
            initialVelocity = 500f
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
            .fillMaxSize()
            .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.animation_decay_animation),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
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