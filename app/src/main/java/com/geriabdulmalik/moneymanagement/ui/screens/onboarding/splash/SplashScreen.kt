package com.geriabdulmalik.moneymanagement.ui.screens.onboarding.splash

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.navigation.Screen
import com.geriabdulmalik.moneymanagement.ui.components.SetSystemUiColor
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, splashViewModel: SplashViewModel = hiltViewModel()) {

    val token by splashViewModel.token.collectAsState()
    SetSystemUiColor(statusBarColor = ColorPrimary, darkIcons = false)

    LaunchedEffect(key1 = null) {
        delay(3000)
        Log.d("ceklogcat", "SplashScreen: $token")
        if (!token.isNullOrEmpty()) {
            navController.navigate(Screen.MainScreen.route) {
                popUpTo(0)
            }
        } else {
            navController.navigate(Screen.LoginScreen.route) {
                popUpTo(0)
            }
        }

    }

    Box(
        modifier = Modifier
            .background(color = ColorPrimary)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun SplashScreenPrev() {
    SplashScreen(navController = rememberNavController())
}