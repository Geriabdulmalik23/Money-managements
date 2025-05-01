package com.geriabdulmalik.moneymanagement.domain.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class FeatureModel(
    var title: String,
    var image: Painter,
    var route: String
)