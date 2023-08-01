package com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun RememberInfiniteTransitionScreen() {
    val infiniteTransition = rememberInfiniteTransition()

    val sizeValue by infiniteTransition.animateFloat(
        initialValue = 48.dp.value,
        targetValue = 128.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1_000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val rotateValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1_000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.remember_infinite_transition),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .rotate(rotateValue)
                .size(sizeValue.dp),
            painter = painterResource(id = R.drawable.vd_cast_green_mono_1_128x128_rounded_corner),
            contentDescription = "remember_infinite_transition"
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { }
        ) { Text(text = stringResource(id = R.string.rotate)) }
    }
}