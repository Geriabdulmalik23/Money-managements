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
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavBar(navController, onFabClick = { navController.navigate("add") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add") },
                containerColor = Color.Blue, // Material3 menggunakan containerColor
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Transaction")
            }
        },
        floatingActionButtonPosition = FabPosition.Center, // FAB di tengah
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
//            NavGraph(navController = navController)
        }
    }
}

@Preview
@Composable
fun MainScreenPrev() {
    MainScreen()
}