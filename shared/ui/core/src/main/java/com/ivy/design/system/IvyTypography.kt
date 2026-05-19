package com.ivy.design.system

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Note: You might need to adjust the 'R' import depending on the exact module namespace during the GitHub Actions build, but this will get it recognized!
import com.ivy.ui.core.R 

val GlassSerifFont = FontFamily(
    Font(R.font.glass_serif_regular, FontWeight.Normal),
    Font(R.font.glass_serif_bold, FontWeight.Bold)
)

val IvyTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = GlassSerifFont,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp
    ),
    titleLarge = TextStyle(
        fontFamily = GlassSerifFont,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = GlassSerifFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = GlassSerifFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
)
