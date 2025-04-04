package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp

@Composable
fun getAdaptiveSize(small: Dp, medium: Dp, large: Dp): Dp {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    return when {
        screenWidthDp < 360 -> small   // Untuk layar kecil (HP kecil)
        screenWidthDp < 600 -> medium  // Untuk layar sedang (HP standar)
        else -> large                  // Untuk layar besar (Tablet)
    }
}