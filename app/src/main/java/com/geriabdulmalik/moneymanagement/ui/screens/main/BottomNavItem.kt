package com.geriabdulmalik.moneymanagement.ui.screens.main

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val isFab: Boolean = false
)
