package com.geriabdulmalik.moneymanagement.ui.screens.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90

@Composable
fun BottomNavBar(navController: NavController, onFabClick: () -> Unit) {

    val items = listOf(
        BottomNavItem(
            "Home",
            "home",
            ImageVector.vectorResource(id = R.drawable.ic_house_stroke_filled),
            ImageVector.vectorResource(id = R.drawable.ic_house_stroke_default)
        ),
        BottomNavItem(
            "Explore",
            "explore",
            ImageVector.vectorResource(id = R.drawable.ic_compass_stroke_default),
            ImageVector.vectorResource(id = R.drawable.ic_compass_stroke_filled)
        ),
        BottomNavItem(
            "Transaction",
            "transactions",
            ImageVector.vectorResource(id = R.drawable.ic_doc_stroke_filled),
            ImageVector.vectorResource(id = R.drawable.ic_doc_stroke_default)
        ),
        BottomNavItem(
            "Account",
            "account",
            ImageVector.vectorResource(id = R.drawable.ic_user_stroke_filled),
            ImageVector.vectorResource(id = R.drawable.ic_user_stroke_default)
        )
    )

    BottomAppBar(
        containerColor = Color.White,
        contentColor = ColorPrimary,
        tonalElevation = 8.dp
    ) {

        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            val isSelected = item.route == currentRoute
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.iconSelected else item.iconUnselected,
                        contentDescription = item.title,

                        )
                },
                label = {
                    Text(
                        item.title,
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ColorPrimary,
                    unselectedIconColor = Gray90
                )
            )
        }

    }
}