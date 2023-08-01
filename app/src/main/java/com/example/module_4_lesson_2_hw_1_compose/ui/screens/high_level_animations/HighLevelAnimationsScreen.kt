package com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun HighLevelAnimationsScreen(
    onAnimatedVisibilityClicked: () -> Unit,
    onAnimatedContentClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.high_level_animations),
            textAlign = TextAlign.Center
        )
        Button(onClick = {
            onAnimatedVisibilityClicked()
        }) { Text(text = stringResource(id = R.string.animated_visibility)) }
        Button(onClick = {
            onAnimatedContentClicked()
        }) { Text(text = stringResource(id = R.string.animated_content)) }
    }
}