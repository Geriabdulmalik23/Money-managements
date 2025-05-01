package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheet(
    open: Boolean,
    onDismissRequest: () -> Unit,
    skipPartiallyExpanded: Boolean = false,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )

    if (open) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            containerColor = Color.White,
            sheetState = bottomSheetState,
            contentColor = Color.White,
        ) {
            content()
        }
    }
}