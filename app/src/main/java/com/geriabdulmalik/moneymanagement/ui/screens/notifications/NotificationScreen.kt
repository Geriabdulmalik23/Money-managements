package com.geriabdulmalik.moneymanagement.ui.screens.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithDivider
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90

@Composable
fun NotificationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarWithDivider(title = "Notifications", showBackButton = true, onBackClick = {
                navController.popBackStack()
            })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_no_notification),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(160.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "No Notification Yet",
                style = AppTypography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Black70
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "You have no notification right now",
                style = AppTypography.bodySmall,
                fontWeight = FontWeight.W400,
                color = Gray90
            )
        }
    }
}

@Preview
@Composable
fun NotificationScreenPrev() {
    NotificationScreen(navController = rememberNavController())
}