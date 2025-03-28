package com.geriabdulmalik.moneymanagement.ui.screens.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary

@Composable
fun BottomNavBar(navController: NavController, onFabClick: () -> Unit) {

    val items = listOf(
        BottomNavItem("Home", "home", Icons.Default.Home),
        BottomNavItem("Statistics", "statistic", Icons.Default.Delete),
        BottomNavItem("Add", "add", Icons.Default.Add),
        BottomNavItem("Wallet", "wallet", Icons.Default.Home),
        BottomNavItem("profile", "profile", Icons.Default.Home)
    )

    BottomAppBar(
        containerColor = Color.White,
        contentColor = ColorPrimary,
        tonalElevation = 8.dp
    ) {

        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            if (!item.isFab) {
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = { navController.navigate(item.route) },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                    label = { Text(item.title) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Blue,
                        unselectedIconColor = Color.Gray
                    )
                )
            } else {
                Spacer(Modifier.weight(1f)) // FAB di tengah
            }
        }

    }
}