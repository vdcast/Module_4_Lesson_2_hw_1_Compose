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
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.AnimatedVisibilityOneScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.AnimatedVisibilityTwoScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.HighLevelAnimationsScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.HomeScreen
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.LowLevelAnimations
import com.example.module_4_lesson_2_hw_1_compose.ui.screens.high_level_animations.AnimatedContentScreen
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
                    onHighLevelClicked = { navController.navigate(ScreenRoutes.HighLevelAnimationsScreen.route) },
                    onLowLevelClicked = { navController.navigate(ScreenRoutes.LowLevelAnimationsScreen.route) }
                )
            }
            composable(ScreenRoutes.HighLevelAnimationsScreen.route) {
                HighLevelAnimationsScreen(
                    onAnimatedVisibilityOneClicked = { navController.navigate(ScreenRoutes.AnimatedVisibilityOneScreen.route) },
                    onAnimatedVisibilityTwoClicked = { navController.navigate(ScreenRoutes.AnimatedVisibilityTwoScreen.route) },
                    onAnimatedContentClicked = { navController.navigate(ScreenRoutes.AnimatedContentScreen.route) }
                )
            }
            composable(ScreenRoutes.LowLevelAnimationsScreen.route) {
                LowLevelAnimations()
            }
            composable(ScreenRoutes.AnimatedVisibilityOneScreen.route) {
                AnimatedVisibilityOneScreen()
            }
            composable(ScreenRoutes.AnimatedVisibilityTwoScreen.route) {
                AnimatedVisibilityTwoScreen()
            }
            composable(ScreenRoutes.AnimatedContentScreen.route) {
                AnimatedContentScreen()
            }
        }
    }

}