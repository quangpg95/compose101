package com.qq.compose101.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColorsPalette(
    val customTextColor: Color = Color.Unspecified
)

val md_theme_light_customText = Color(0xFF006C4F)

val md_theme_dark_customText = Color(0xFF68DBAF)

val LightCustomColorsPalette = CustomColorsPalette(
    customTextColor = md_theme_light_customText,
)

val DarkCustomColorsPalette = CustomColorsPalette(
    customTextColor = md_theme_dark_customText,
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }

val MaterialTheme.customColorsPalette: CustomColorsPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColorsPalette.current