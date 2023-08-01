package com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import com.example.module_4_lesson_2_hw_1_compose.R

@Composable
fun CrossfadeScreen() {
    var visibleState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.crossfade),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Crossfade(targetState = visibleState) { screen ->
            when (screen) {
                true -> SomeImage()
                false -> SomeText()
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { visibleState = !visibleState }
        ) { Text(text = stringResource(id = R.string.change_visibility)) }
    }
}

@Composable
fun SomeImage() {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(128.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.vd_cast_green_mono_1_128x128_rounded_corner),
            contentDescription = "crossfade image"
        )
    }
}

@Composable
fun SomeText() {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(128.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.some_text))
    }
}