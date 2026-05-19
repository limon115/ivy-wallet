import os
import re

gradle_file = "shared/ui/core/build.gradle.kts"
kt_file = "shared/ui/core/src/main/java/com/ivy/design/system/IvyTypography.kt"

try:
    # Extract the true namespace again to be safe
    with open(gradle_file, "r") as f:
        gradle_content = f.read()
    
    namespace_match = re.search(r'namespace\s*=\s*["\'](.*?)["\']', gradle_content)
    real_namespace = namespace_match.group(1) if namespace_match else "com.ivy.ui.core"
    
    # Bulletproof Material 3 Typography implementation
    new_kt_content = f"""package com.ivy.design.system

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import {real_namespace}.R

val GlassSerifFont = FontFamily(
    Font(R.font.glass_serif_regular, FontWeight.Normal),
    Font(R.font.glass_serif_bold, FontWeight.Bold)
)

// By defining a baseline and copying it, we ensure NO text styles are left undefined!
private val defaultTypography = Typography()

val IvyTypography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = GlassSerifFont),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = GlassSerifFont),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = GlassSerifFont),
    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = GlassSerifFont),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = GlassSerifFont),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = GlassSerifFont),
    titleLarge = defaultTypography.titleLarge.copy(fontFamily = GlassSerifFont),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = GlassSerifFont),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = GlassSerifFont),
    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = GlassSerifFont),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = GlassSerifFont),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = GlassSerifFont),
    labelLarge = defaultTypography.labelLarge.copy(fontFamily = GlassSerifFont),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = GlassSerifFont),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = GlassSerifFont)
)
"""
    with open(kt_file, "w") as f:
        f.write(new_kt_content)
    print("✅ SURGICAL REPAIR SUCCESSFUL: Bulletproof Typography injected.")
except Exception as e:
    print(f"❌ Error: {e}")
