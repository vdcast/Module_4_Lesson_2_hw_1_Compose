package com.example.module_4_lesson_2_hw_1_compose.ui.navigation

sealed class ScreenRoutes(val route: String) {
    object HomeScreen : ScreenRoutes("home_screen")
    object HighLevelAnimationsScreen : ScreenRoutes("high_level_animations_screen")
    object LowLevelAnimationsScreen : ScreenRoutes("low_level_animations_screen")
    object AnimatedVisibilityOneScreen : ScreenRoutes("animated_visibility_one_screen")
    object AnimatedVisibilityTwoScreen : ScreenRoutes("animated_visibility_two_screen")
    object AnimatedContentScreen : ScreenRoutes("animated_content_screen")
}
