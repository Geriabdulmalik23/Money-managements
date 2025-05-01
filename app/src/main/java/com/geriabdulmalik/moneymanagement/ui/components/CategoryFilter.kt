package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.White90

@Composable
fun CategoryFilter(
    categories: List<String>,
    selectedIndex: Int,
    onSelectedChanged: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        categories.forEachIndexed { index, category ->
            val isSelected = index == selectedIndex

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (isSelected) ColorPrimary else White90,
                onClick = { onSelectedChanged(index) },
                tonalElevation = 0.dp
            ) {
                Text(
                    text = category,
                    modifier = Modifier
                        .width(84.dp)
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    style = AppTypography.bodySmall,
                    color = if (isSelected) Color.White else Color.Gray,
                    fontWeight = FontWeight.W400
                )
            }
        }
    }
}