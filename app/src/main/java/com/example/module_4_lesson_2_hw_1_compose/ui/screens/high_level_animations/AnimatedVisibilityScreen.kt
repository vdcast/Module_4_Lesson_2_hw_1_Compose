package com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun AnimatedVisibilityScreen() {
    var visibleOne by remember { mutableStateOf(false) }
    var visibleTwo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.animated_visibility),
            textAlign = TextAlign.Center
        )
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = visibleOne,
            enter = slideInHorizontally() + expandHorizontally(expandFrom = Alignment.End)
                    + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { fullWidth ->  fullWidth})
                    + shrinkHorizontally() + fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.vd_cast_green_mono_1_128x128_rounded_corner),
                contentDescription = "animated_visibility_1"
            )
        }
        AnimatedVisibility(
            visible = visibleTwo,
            enter = fadeIn(animationSpec = tween(durationMillis = 300, easing = LinearEasing)),
            exit = fadeOut(animationSpec = tween(durationMillis = 300))
        ) {
            Image(
                painter = painterResource(id = R.drawable.vd_cast_green_mono_1_128x128_rounded_corner),
                contentDescription = "animated_visibility_1"
            )
        }
        Column() {
            Button(
                modifier = Modifier.fillMaxWidth(0.7f),
                onClick = { visibleOne = !visibleOne }
            ) { Text(text = stringResource(id = R.string.animated_visibility_1)) }
            Button(
                modifier = Modifier.fillMaxWidth(0.7f),
                onClick = { visibleTwo = !visibleTwo }
            ) { Text(text = stringResource(id = R.string.animated_visibility_2)) }
        }
    }
}