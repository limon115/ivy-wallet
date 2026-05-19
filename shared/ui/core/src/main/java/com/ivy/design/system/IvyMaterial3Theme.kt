package com.ivy.design.system

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.ivy.design.system.colors.IvyColors

@Composable
fun IvyMaterial3Theme(
    isTrueBlack: Boolean,
    dark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (dark) ivyDarkColorScheme(isTrueBlack) else ivyLightColorScheme(),
        typography = IvyTypography, // 🔤 Fully hooked up to the bulletproof custom font!
        content = content,
    )
}

private fun ivyLightColorScheme(): ColorScheme = ColorScheme(
    primary = IvyColors.Purple.primary,
    onPrimary = IvyColors.White,
    primaryContainer = IvyColors.Purple.light,
    onPrimaryContainer = IvyColors.White,
    inversePrimary = IvyColors.Purple.dark,
    secondary = IvyColors.Green.primary,
    onSecondary = IvyColors.White,
    secondaryContainer = IvyColors.Green.light,
    onSecondaryContainer = IvyColors.White,
    tertiary = IvyColors.Green.primary,
    onTertiary = IvyColors.White,
    tertiaryContainer = IvyColors.Green.light,
    onTertiaryContainer = IvyColors.White,

    error = IvyColors.Red.primary,
    onError = IvyColors.White,
    errorContainer = IvyColors.Red.light,
    onErrorContainer = IvyColors.White,

    background = IvyColors.White,
    onBackground = IvyColors.Black,
    
    // 🧊 GLASSMORPHISM LIGHT MODE TWEAKS 🧊
    surface = IvyColors.White.copy(alpha = 0.4f), 
    onSurface = IvyColors.Black,
    surfaceVariant = IvyColors.ExtraLightGray.copy(alpha = 0.2f),
    onSurfaceVariant = IvyColors.Black,
    
    surfaceTint = IvyColors.Black,
    inverseSurface = IvyColors.DarkGray,
    inverseOnSurface = IvyColors.White,

    outline = IvyColors.Gray.copy(alpha = 0.5f), 
    outlineVariant = IvyColors.DarkGray.copy(alpha = 0.3f),
    scrim = IvyColors.ExtraDarkGray.copy(alpha = 0.8f)
)

private fun ivyDarkColorScheme(isTrueBlack: Boolean): ColorScheme = ColorScheme(
    primary = IvyColors.Purple.primary,
    onPrimary = IvyColors.White,
    primaryContainer = IvyColors.Purple.light,
    onPrimaryContainer = IvyColors.White,
    inversePrimary = IvyColors.Purple.dark,
    secondary = IvyColors.Green.primary,
    onSecondary = IvyColors.White,
    secondaryContainer = IvyColors.Green.light,
    onSecondaryContainer = IvyColors.White,
    tertiary = IvyColors.Green.primary,
    onTertiary = IvyColors.White,
    tertiaryContainer = IvyColors.Green.light,
    onTertiaryContainer = IvyColors.White,

    error = IvyColors.Red.primary,
    onError = IvyColors.White,
    errorContainer = IvyColors.Red.light,
    onErrorContainer = IvyColors.White,

    background = if (isTrueBlack) IvyColors.TrueBlack else IvyColors.Black,
    onBackground = IvyColors.White,
    
    // 🧊 GLASSMORPHISM DARK MODE TWEAKS 🧊
    surface = (if (isTrueBlack) IvyColors.TrueBlack else IvyColors.Black).copy(alpha = 0.4f),
    onSurface = IvyColors.White,
    surfaceVariant = IvyColors.ExtraDarkGray.copy(alpha = 0.3f),
    onSurfaceVariant = IvyColors.White,
    
    surfaceTint = IvyColors.White,
    inverseSurface = IvyColors.LightGray,
    inverseOnSurface = if (isTrueBlack) IvyColors.TrueBlack else IvyColors.Black,

    outline = IvyColors.Gray.copy(alpha = 0.5f),
    outlineVariant = IvyColors.LightGray.copy(alpha = 0.2f),
    scrim = IvyColors.ExtraLightGray.copy(alpha = 0.8f)
)
