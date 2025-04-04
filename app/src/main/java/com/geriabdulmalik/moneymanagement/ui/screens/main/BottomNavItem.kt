package com.geriabdulmalik.moneymanagement.ui.screens.main

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val route: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector
)
