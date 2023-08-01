package com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun UpdateTransitionScreen() {
    var state by remember { mutableStateOf(false) }
    val transition = updateTransition(state, label = "")
    val sizeValue by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1_000) },
        label = ""
    ) { screenState ->
        if (screenState) {
            128.dp
        } else {
            64.dp
        }
    }
    val rotateValue by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 1_000) },
        label = ""
    ) { screeState ->
        if (screeState) {
            0f
        } else {
            360f
        }
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
            text = stringResource(id = R.string.update_transition),
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .rotate(rotateValue)
                .size(sizeValue),
            painter = painterResource(id = R.drawable.vd_cast_green_mono_1_128x128_rounded_corner),
            contentDescription = "animated_visibility_1"
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { state = !state }
        ) { Text(text = stringResource(id = R.string.start_animation)) }
    }
}