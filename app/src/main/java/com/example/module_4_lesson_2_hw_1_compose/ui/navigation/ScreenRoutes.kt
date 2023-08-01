package com.example.module_4_lesson_2_hw_1_compose.ui.navigation

sealed class ScreenRoutes(val route: String) {
    object HomeScreen : ScreenRoutes("home_screen")
    object HighLevelAnimationsScreen : ScreenRoutes("high_level_animations_screen")
    object LowLevelAnimationsScreen : ScreenRoutes("low_level_animations_screen")
    object AnimatedVisibilityScreen : ScreenRoutes("animated_visibility_screen")
    object AnimatedContentScreen : ScreenRoutes("animated_content_screen")
    object CrossfadeScreen : ScreenRoutes("crossfade_screen")
    object ModifierAnimateContentSizeScreen : ScreenRoutes("modifier_animate_content_size_screen")
}
