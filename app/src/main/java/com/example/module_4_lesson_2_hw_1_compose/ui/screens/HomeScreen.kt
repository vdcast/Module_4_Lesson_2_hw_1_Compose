package com.example.module_4_lesson_2_hw_1_compose.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import com.example.module_4_lesson_2_hw_1_compose.R
import com.example.module_4_lesson_2_hw_1_compose.ui.theme.Module_4_Lesson_2_hw_1_ComposeTheme

@Composable
fun HomeScreen(
    onHighLevelClick: () -> Unit,
    onLowLevelClick: () -> Unit
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
            text = stringResource(id = R.string.home_title),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onHighLevelClick() }
        ) { Text(text = stringResource(id = R.string.high_level_animations)) }
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { onLowLevelClick() }
        ) { Text(text = stringResource(id = R.string.low_level_animations)) }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Module_4_Lesson_2_hw_1_ComposeTheme {
        HomeScreen({}, {})
    }
}