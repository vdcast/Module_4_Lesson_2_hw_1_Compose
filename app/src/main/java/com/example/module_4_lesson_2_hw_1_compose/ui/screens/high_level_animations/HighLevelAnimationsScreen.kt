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
import androidx.compose.ui.tooling.preview.Preview
import com.example.module_4_lesson_2_hw_1_compose.R
import com.example.module_4_lesson_2_hw_1_compose.ui.theme.Module_4_Lesson_2_hw_1_ComposeTheme

@Composable
fun HighLevelAnimationsScreen(
    onAnimatedVisibilityOneClicked: () -> Unit,
    onAnimatedVisibilityTwoClicked: () -> Unit,
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
            onAnimatedVisibilityOneClicked()
        }) { Text(text = stringResource(id = R.string.animated_visibility_1)) }
        Button(onClick = {
            onAnimatedVisibilityTwoClicked()
        }) { Text(text = stringResource(id = R.string.animated_visibility_2)) }
        Button(onClick = {
            onAnimatedContentClicked()
        }) { Text(text = stringResource(id = R.string.animated_content)) }
    }
}