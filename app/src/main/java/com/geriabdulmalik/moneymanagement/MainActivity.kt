package com.geriabdulmalik.moneymanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.navigation.AppNavigation
import com.geriabdulmalik.moneymanagement.ui.theme.MoneyManagementTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyManagementTheme(dynamicColor = false) {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
