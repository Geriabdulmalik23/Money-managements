package com.geriabdulmalik.moneymanagement.ui.screens.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.components.CustomTextMedium
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithDivider
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingLarge
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingMedium
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingMini
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingSmall
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.Red100
import com.geriabdulmalik.moneymanagement.ui.theme.Red12Opacity
import com.geriabdulmalik.moneymanagement.ui.theme.White90
import kotlinx.coroutines.delay

@Composable
fun DetailPaymentScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarWithDivider(title = "Payment", onBackClick = {
                navController.navigate("main") {
                    popUpTo(0) { inclusive = true } // clear semua
                    launchSingleTop = true
                }
            }, showBackButton = true)
        },
        bottomBar = {
            Card(
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 1.dp
                ),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.White
                )
            ) {
                Surface(
                    tonalElevation = 8.dp,
                    shape = RoundedCornerShape(corner = CornerSize(PaddingMini)),
                    border = BorderStroke(width = 1.dp, color = Red100),
                    color = Color.Transparent,
                    modifier = Modifier.padding(horizontal = PaddingLarge, vertical = PaddingSmall)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("main") {
                                    popUpTo(0) { inclusive = true }
                                    launchSingleTop = true
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            shape = RoundedCornerShape(PaddingMini),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        ) {
                            CustomTextMedium(text = "Cancel", color = Red100)
                        }
                    }
                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Color.White)
        ) {
            Spacer(modifier = Modifier.height(PaddingLarge))
            CountdownTimer {

            }
            Spacer(modifier = Modifier.height(PaddingLarge))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = PaddingLarge)
                    .background(color = White90, shape = RoundedCornerShape(PaddingMini)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.asset_qr_code_default),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                )
            }
            Spacer(modifier = Modifier.height(PaddingLarge))

            CustomTextMedium(
                text = "Payment Instructions.",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Black70,
                modifier = Modifier.padding(horizontal = PaddingLarge)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomTextMedium(
                text = "1.  Open your payment application.",
                color = Gray90,
                modifier = Modifier.padding(horizontal = PaddingLarge, vertical = PaddingMini),
            )
            CustomTextMedium(
                text = "2.  Select the QRIS menu as the payment method.",
                color = Gray90,
                modifier = Modifier.padding(horizontal = PaddingLarge, vertical = PaddingMini),
            )
            CustomTextMedium(
                text = "3.  Scan the QR code above.",
                color = Gray90,
                modifier = Modifier.padding(horizontal = PaddingLarge, vertical = PaddingMini),
            )
            CustomTextMedium(
                text = "4.  Verify the transaction with your PIN or password.",
                color = Gray90,
                modifier = Modifier.padding(horizontal = PaddingLarge, vertical = PaddingMini),
            )
            CustomTextMedium(
                text = "5.  Done.",
                color = Gray90,
                modifier = Modifier.padding(horizontal = PaddingLarge, vertical = PaddingMini),
            )

        }
    }
}

@Composable
fun CountdownTimer(
    totalTime: Long = 15 * 60, // 15 menit
    onFinish: () -> Unit
) {
    var remainingTime by remember { mutableStateOf(totalTime) }

    LaunchedEffect(key1 = remainingTime) {
        if (remainingTime > 0) {
            delay(1000)
            remainingTime--
        } else {
            onFinish()
        }
    }

    val minutes = (remainingTime / 60).toString().padStart(2, '0')
    val seconds = (remainingTime % 60).toString().padStart(2, '0')

    Row(
        modifier = Modifier
            .padding(horizontal = PaddingLarge)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomTextMedium(text = "Make the Payment Before", color = Gray90)
        Surface(
            modifier = Modifier,
            shape = RoundedCornerShape(corner = CornerSize(PaddingLarge)),
            border = BorderStroke(width = 1.dp, color = Red100),
            color = Red12Opacity
        ) {
            CustomTextMedium(
                text = "$minutes : $seconds",
                modifier = Modifier.padding(horizontal = PaddingMini, vertical = 4.dp),
            )
        }

    }
}

@Preview
@Composable
fun DetailPaymentScreenPrev() {
    DetailPaymentScreen(navController = rememberNavController())
}