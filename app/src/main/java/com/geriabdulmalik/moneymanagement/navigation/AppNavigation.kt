package com.geriabdulmalik.moneymanagement.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.LoginScreen
import com.geriabdulmalik.moneymanagement.ui.screens.main.MainScreen
import com.geriabdulmalik.moneymanagement.ui.screens.onboarding.onboarding.OnboardingScreen
import com.geriabdulmalik.moneymanagement.ui.screens.onboarding.splash.SplashScreen

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splashscreen")
    object OnboardingScreen : Screen("onboarding")
    object LoginScreen : Screen("login")
    object MainScreen : Screen("main")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.OnboardingScreen.route) {
            OnboardingScreen(navController = navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.MainScreen.route){
            MainScreen()
        }
    }
}