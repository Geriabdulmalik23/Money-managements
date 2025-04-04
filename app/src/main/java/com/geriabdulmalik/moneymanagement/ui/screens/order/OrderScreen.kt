package com.geriabdulmalik.moneymanagement.ui.screens.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.components.CustomTextMedium
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithDivider
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70

@Composable
fun OrderScreen(navController: NavController) {
    Scaffold(topBar = {
        TopBarWithDivider(title = "Top Up Game", showBackButton = true) {
            navController.popBackStack()
        }
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner_transaction),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(24.dp))
            featureGame()
        }
    }
}

@Composable
fun featureGame() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {

        CustomTextMedium(text = "Game ID", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(12.dp))



    }
}

@Preview
@Composable
fun OrderScreenPrev() {
    OrderScreen(navController = rememberNavController())
}