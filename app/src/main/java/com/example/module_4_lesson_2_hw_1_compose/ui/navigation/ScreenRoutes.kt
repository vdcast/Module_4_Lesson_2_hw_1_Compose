package com.example.module_4_lesson_2_hw_1_compose.ui.navigation

sealed class ScreenRoutes(val route: String) {
    object HomeScreen : ScreenRoutes("home_screen")
    object HighLevelAnimations : ScreenRoutes("high_level_animations")
    object LowLevelAnimations : ScreenRoutes("low_level_animations")
    object AnimatedVisibilityOne : ScreenRoutes("animated_visibility_one")
    object AnimatedVisibilityTwo : ScreenRoutes("animated_visibility_two")
}
