package com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.module_4_lesson_2_hw_1_compose.R
import com.example.module_4_lesson_2_hw_1_compose.ui.theme.Green20

@Composable
fun ModifierAnimateContentSizeScreen() {
    var visible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.modifier_animateContentSize),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .background(Green20)
                .animateContentSize()
        ) {
            HeaderItem(visible = visible) { visible = !visible }

            if (visible) {
                Text(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
                    text = stringResource(id = R.string.long_text)
                )
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { visible = !visible }
        ) { Text(text = stringResource(id = R.string.change_visibility)) }
    }
}

@Composable
fun HeaderItem(visible: Boolean, onTitleClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onTitleClick() }
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_medium),
                vertical = dimensionResource(id = R.dimen.padding_small)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.title))
        if (visible) {
            Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "arrow up")
        } else {
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "arrow down")
        }
    }
}