package com.geriabdulmalik.moneymanagement.ui.screens.order

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90

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

    val gameIdText = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {

        CustomTextMedium(text = "Game ID", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = Modifier.weight(1.0f)) {
                TextField(
                    value = gameIdText.value,
                    onValueChange = { gameIdText.value = it },
                    placeholder = {
                        CustomTextMedium(
                            text = "Game ID",
                            color = Gray90,
                            modifier = Modifier.fillMaxWidth()
                        )
                    })
            }
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 8.dp)
            ) {
                TextField(
                    value = gameIdText.value,
                    onValueChange = { gameIdText.value = it },
                    placeholder = {
                        CustomTextMedium(
                            text = "Game ID",
                            color = Gray90,
                            modifier = Modifier.fillMaxWidth()
                        )
                    })
            }
        }
    }
}

@Preview
@Composable
fun OrderScreenPrev() {
    OrderScreen(navController = rememberNavController())
}