package com.geriabdulmalik.moneymanagement.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.navigation.NavigationGraph
import com.geriabdulmalik.moneymanagement.ui.components.SetSystemUiColor
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary

@Composable
fun MainScreen(navMainController: NavController) {
    SetSystemUiColor(statusBarColor = Color.White, darkIcons = true)

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavBar(navController, onFabClick = { navController.navigate("add") }) },
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            NavigationGraph(navController = navMainController, navHostController = navController)
        }
    }
}

@Preview
@Composable
fun MainScreenPrev() {
    MainScreen(rememberNavController())
}