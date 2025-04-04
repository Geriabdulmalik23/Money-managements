package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.geriabdulmalik.moneymanagement.R
import kotlinx.coroutines.delay

@Composable
fun LoadingDialog(isLoading: Boolean, onDismiss: () -> Unit) {
    if (isLoading) {
        Dialog(onDismissRequest = {}) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                var toggle by remember { mutableStateOf(false) }

                // Toggle antara gambar setiap 500ms
                LaunchedEffect(Unit) {
                    while (true) {
                        delay(500) // Ganti setiap 500ms
                        toggle = !toggle
                    }
                }

                AnimatedContent(
                    targetState = toggle,
                    label = "SpinnerAnimation",
                    transitionSpec = {
                        (fadeIn(animationSpec = tween(3000)) togetherWith  fadeOut(animationSpec = tween(3000)))
                            .using(SizeTransform(clip = false))
                    }
                ) { state ->
                    Image(
                        painter = painterResource(
                            if (state) R.drawable.ic_spinner_on else R.drawable.ic_spinner_off
                        ),
                        contentDescription = "Loading Spinner",
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LoadingDialogPrev() {
    LoadingDialog(isLoading = true) {

    }
}