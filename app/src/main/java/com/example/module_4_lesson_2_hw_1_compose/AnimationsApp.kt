package com.example.module_4_lesson_2_hw_1_compose

import androidx.compose.runtime.Composable
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

@Composable
fun AnimationsApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.HomeScreen.route
    ) {
        composable(ScreenRoutes.HomeScreen.route) {
            HomeScreen(
                onHighLevelClicked = { navController.navigate(ScreenRoutes.HighLevelAnimations.route) },
                onLowLevelClicked = { navController.navigate(ScreenRoutes.LowLevelAnimations.route) }
            )
        }
        composable(ScreenRoutes.HighLevelAnimations.route) {
            HighLevelAnimationsScreen(
                onAnimatedVisibilityOneClicked = { navController.navigate(ScreenRoutes.AnimatedVisibilityOne.route) },
                onAnimatedVisibilityTwoClicked = { navController.navigate(ScreenRoutes.AnimatedVisibilityTwo.route) }
            )
        }
        composable(ScreenRoutes.LowLevelAnimations.route) {
            LowLevelAnimations()
        }
        composable(ScreenRoutes.AnimatedVisibilityOne.route) {
            AnimatedVisibilityOneScreen()
        }
        composable(ScreenRoutes.AnimatedVisibilityTwo.route) {
            AnimatedVisibilityTwoScreen()
        }
    }
}