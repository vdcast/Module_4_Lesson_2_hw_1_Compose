package com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.example.module_4_lesson_2_hw_1_compose.R
import com.example.module_4_lesson_2_hw_1_compose.ui.theme.Green20
import com.example.module_4_lesson_2_hw_1_compose.ui.theme.Module_4_Lesson_2_hw_1_ComposeTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentScreen() {
    var visibleState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.animated_content),
            textAlign = TextAlign.Center
        )
        AnimatedContent(
            targetState = visibleState,
            transitionSpec = {
                fadeIn(animationSpec = tween(durationMillis = 150)) with
                        fadeOut(animationSpec = tween(durationMillis = 150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (visibleState) {
                                keyframes {
                                    IntSize(initialSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            } else {
                                keyframes {
                                    IntSize(targetSize.width, targetSize.height) at 150
                                    durationMillis = 300
                                }
                            }
                        }
            }
        ) { targetVisible ->
            if (targetVisible) {
                Expanded() { visibleState = !visibleState }
            } else {
                Collapsed() { visibleState = !visibleState }
            }
        }
        Button(onClick = {
            visibleState = !visibleState
        }) { Text(text = stringResource(id = R.string.change_visibility)) }
    }
}

@Composable
fun Collapsed(
    onImageClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(Green20)
            .fillMaxWidth(0.95f)
            .padding(dimensionResource(id = R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.long_text),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Image(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.padding_large))
                .clickable { onImageClick() },
            painter = painterResource(id = R.drawable.hide),
            contentDescription = "icon hide")
    }
}


@Composable
fun Expanded(
    onImageClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(Green20)
            .fillMaxWidth(0.95f)
            .padding(dimensionResource(id = R.dimen.padding_small)),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.long_text)
        )
        Image(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.padding_large))
                .clickable { onImageClick() },
            painter = painterResource(id = R.drawable.view),
            contentDescription = "icon view")
    }
}