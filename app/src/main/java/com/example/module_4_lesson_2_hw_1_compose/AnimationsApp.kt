package com.example.module_4_lesson_2_hw_1_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.module_4_lesson_2_hw_1_compose.ui.navigation.ScreenRoutes
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.HomeScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations.LowLevelAnimations
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.AnimatedContentScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.AnimatedVisibilityScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.CrossfadeScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.HighLevelAnimationsScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.ModifierAnimateContentSizeScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations.AnimatableScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations.AnimateAsStateScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations.AnimationDecayAnimationScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations.AnimationTargetBasedAnimationScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations.RememberInfiniteTransitionScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.low_level_animations.UpdateTransitionScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.theme.Green10

@Composable
fun AnimationsApp(
    navController: NavHostController = rememberNavController()
) {
    Box(modifier = Modifier.background(Green10)) {
        NavHost(
            navController = navController,
            startDestination = ScreenRoutes.HomeScreen.route
        ) {
            composable(ScreenRoutes.HomeScreen.route) {
                HomeScreen(
                    onHighLevelClick = { navController.navigate(ScreenRoutes.HighLevelAnimationsScreen.route) },
                    onLowLevelClick = { navController.navigate(ScreenRoutes.LowLevelAnimationsScreen.route) }
                )
            }
            composable(ScreenRoutes.HighLevelAnimationsScreen.route) {
                HighLevelAnimationsScreen(
                    onAnimatedVisibilityClick = {
                        navController.navigate(ScreenRoutes.AnimatedVisibilityScreen.route)
                    },
                    onAnimatedContentClick = {
                        navController.navigate(ScreenRoutes.AnimatedContentScreen.route)
                    },
                    onCrossfadeClick = {
                        navController.navigate(ScreenRoutes.CrossfadeScreen.route)
                    },
                    onModifierAnimateContentSizeClick = {
                        navController.navigate(ScreenRoutes.ModifierAnimateContentSizeScreen.route)
                    }
                )
            }
            composable(ScreenRoutes.LowLevelAnimationsScreen.route) {
                LowLevelAnimations(
                    onAnimatableClick = {
                        navController.navigate(ScreenRoutes.AnimatableScreen.route)
                    },
                    onAnimateAsStateClick = {
                        navController.navigate(ScreenRoutes.AnimateAsStateScreen.route)
                    },
                    onAnimationTargetBasedAnimationClick = {
                        navController.navigate(ScreenRoutes.AnimationTargetBasedAnimationScreen.route)
                    },
                    onAnimationDecayAnimationClick = {
                        navController.navigate(ScreenRoutes.AnimationDecayAnimationScreen.route)
                    },
                    onUpdateTransitionClick = {
                        navController.navigate(ScreenRoutes.UpdateTransitionScreen.route)
                    },
                    onRememberInfiniteTransitionClick = {
                        navController.navigate(ScreenRoutes.RememberInfiniteTransitionScreen.route)
                    }
                )
            }
            composable(ScreenRoutes.AnimatedVisibilityScreen.route) {
                AnimatedVisibilityScreen()
            }
            composable(ScreenRoutes.AnimatedContentScreen.route) {
                AnimatedContentScreen()
            }
            composable(ScreenRoutes.CrossfadeScreen.route) {
                CrossfadeScreen()
            }
            composable(ScreenRoutes.ModifierAnimateContentSizeScreen.route) {
                ModifierAnimateContentSizeScreen()
            }
            composable(ScreenRoutes.AnimatableScreen.route) {
                AnimatableScreen()
            }
            composable(ScreenRoutes.AnimateAsStateScreen.route) {
                AnimateAsStateScreen()
            }
            composable(ScreenRoutes.AnimationTargetBasedAnimationScreen.route) {
                AnimationTargetBasedAnimationScreen()
            }
            composable(ScreenRoutes.AnimationDecayAnimationScreen.route) {
                AnimationDecayAnimationScreen()
            }
            composable(ScreenRoutes.UpdateTransitionScreen.route) {
                UpdateTransitionScreen()
            }
            composable(ScreenRoutes.RememberInfiniteTransitionScreen.route) {
                RememberInfiniteTransitionScreen()
            }
        }
    }

}