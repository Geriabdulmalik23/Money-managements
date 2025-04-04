package com.geriabdulmalik.moneymanagement.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.geriabdulmalik.moneymanagement.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

// 🎨 Custom Font (Poppins)
val Helvetica = FontFamily(
    Font(R.font.hnt_regular),
    Font(R.font.hnt_medium),
    Font(R.font.hnt_bold)
)

// 🔤 Typography System
val AppTypography = Typography(
    displayLarge = TextStyle(fontFamily = Helvetica, fontSize = 40.sp),
    headlineLarge = TextStyle(fontFamily = Helvetica, fontSize = 28.sp),
    titleMedium = TextStyle(fontFamily = Helvetica, fontSize = 20.sp),
    titleSmall = TextStyle(fontFamily = Helvetica, fontSize = 18.sp),
    bodyLarge = TextStyle(fontFamily = Helvetica, fontSize = 16.sp),
    bodySmall = TextStyle(fontFamily = Helvetica, fontSize = 14.sp),
    labelMedium = TextStyle(fontFamily = Helvetica, fontSize = 12.sp),
    labelSmall = TextStyle(fontFamily = Helvetica, fontSize = 10.sp)
)