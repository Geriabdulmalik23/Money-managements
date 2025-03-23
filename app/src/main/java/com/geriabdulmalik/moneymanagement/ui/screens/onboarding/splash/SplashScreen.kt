package com.geriabdulmalik.moneymanagement.ui.screens.onboarding.splash

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.geriabdulmalik.moneymanagement.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, splashViewModel: SplashViewModel = hiltViewModel()) {

    val token by splashViewModel.token.collectAsState()

    LaunchedEffect(key1 = null) {
        delay(3000)

        if (!token.isNullOrEmpty()) {
            navController.navigate(Screen.MainScreen.route) {
                popUpTo(0)
            }
        } else {
            navController.navigate(Screen.OnboardingScreen.route) {
                popUpTo(0)
            }
        }

    }

    Box(
        modifier = Modifier
            .background(color = Color(0xFF2A7C76))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "GEER", fontWeight = FontWeight.Bold, fontSize = 50.sp, color = Color.White)
    }
}

@Preview
@Composable
fun SplashScreenPrev() {
//    SplashScreen()
}