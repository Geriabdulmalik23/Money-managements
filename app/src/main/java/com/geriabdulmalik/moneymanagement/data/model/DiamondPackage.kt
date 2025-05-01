package com.geriabdulmalik.moneymanagement.data.model

data class DiamondPackage(
    val id: String,
    val displayText: String,
    val totalDiamonds: Int,
    val baseDiamonds: Int,
    val bonusDiamonds: Int,
    val price: Double
)
