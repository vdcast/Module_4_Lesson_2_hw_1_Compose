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
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.LowLevelAnimations
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.AnimatedContentScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.AnimatedVisibilityScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.CrossfadeScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.HighLevelAnimationsScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.ModifierAnimateContentSizeScreen
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
                LowLevelAnimations()
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
        }
    }

}