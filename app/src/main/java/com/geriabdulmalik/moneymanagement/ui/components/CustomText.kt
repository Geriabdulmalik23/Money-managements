package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70

@Composable
fun CustomTextMedium(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.W400,
    color: Color = Black70,
) {
    Text(
        text = text,
        style = AppTypography.bodySmall,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )

}