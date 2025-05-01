package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90

@Composable
fun DashedLine(modifier: Modifier = Modifier, color: Color = Gray100) {
    Box(
        modifier = modifier
            .height(1.dp)
            .fillMaxWidth()
            .drawBehind {
                val dashWidth = 10.dp.toPx()
                val gapWidth = 2.dp.toPx()
                var startX = 0f

                while (startX < size.width) {
                    drawLine(
                        color = color,
                        start = Offset(x = startX, y = 0f),
                        end = Offset(x = startX + dashWidth, y = 0f),
                        strokeWidth = size.height
                    )
                    startX += dashWidth + gapWidth
                }
            }
    )
}