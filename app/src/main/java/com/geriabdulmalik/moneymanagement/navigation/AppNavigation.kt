package com.geriabdulmalik.moneymanagement.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.LoginScreen
import com.geriabdulmalik.moneymanagement.ui.screens.main.MainScreen
import com.geriabdulmalik.moneymanagement.ui.screens.main.account.AccountScreen
import com.geriabdulmalik.moneymanagement.ui.screens.main.explore.ExploreScreen
import com.geriabdulmalik.moneymanagement.ui.screens.main.home.HomeScreen
import com.geriabdulmalik.moneymanagement.ui.screens.main.transaction.TransactionScreen
import com.geriabdulmalik.moneymanagement.ui.screens.notifications.NotificationScreen
import com.geriabdulmalik.moneymanagement.ui.screens.onboarding.onboarding.OnboardingScreen
import com.geriabdulmalik.moneymanagement.ui.screens.onboarding.splash.SplashScreen

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splashscreen")
    object OnboardingScreen : Screen("onboarding")
    object LoginScreen : Screen("login")
    object MainScreen : Screen("main")
    object NotificationScreen : Screen("notification")

    //BottomNavigation
    object HomeScreen : Screen("home")
    object ExploreScreen : Screen("explore")
    object TransactionScreen : Screen("transactions")
    object AccountScreen : Screen("account")
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

        composable(Screen.MainScreen.route) {
            MainScreen(navMainController = navController)
        }

        composable(Screen.NotificationScreen.route) {
            NotificationScreen(navController = navController)
        }
    }
}

//Navigation For The Main Screen
@Composable
fun NavigationGraph(navHostController: NavHostController, navController: NavController) {

    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.ExploreScreen.route) {
            ExploreScreen()
        }
        composable(Screen.TransactionScreen.route) {
            TransactionScreen()
        }
        composable(Screen.AccountScreen.route) {
            AccountScreen()
        }
    }
}