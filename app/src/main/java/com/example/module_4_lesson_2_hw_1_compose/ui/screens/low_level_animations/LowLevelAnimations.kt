package com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun LowLevelAnimations(
    onAnimatableClick: () -> Unit,
    onAnimateAsStateClick: () -> Unit,
    onAnimationTargetBasedAnimationClick: () -> Unit,
    onAnimationDecayAnimationClick: () -> Unit,
    onUpdateTransitionClick: () -> Unit,
    onRememberInfiniteTransitionClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
            text = stringResource(id = R.string.low_level_animations),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onAnimatableClick() }
        ) { Text(text = stringResource(id = R.string.animatable)) }
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onAnimateAsStateClick() }
        ) { Text(text = stringResource(id = R.string.animate_as_state)) }
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onAnimationTargetBasedAnimationClick() }
        ) { Text(text = stringResource(id = R.string.animation_target_based_animation)) }
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onAnimationDecayAnimationClick() }
        ) { Text(text = stringResource(id = R.string.animation_decay_animation)) }
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onUpdateTransitionClick() }
        ) { Text(text = stringResource(id = R.string.update_transition)) }
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onRememberInfiniteTransitionClick() }
        ) { Text(text = stringResource(id = R.string.remember_infinite_transition)) }
    }
}