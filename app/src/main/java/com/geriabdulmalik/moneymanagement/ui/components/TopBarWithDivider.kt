package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.navigation.Screen
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithDivider(
    title: String,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {}
) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    style = AppTypography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Black70,
                    modifier = Modifier
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.White
            ),
            navigationIcon = {
                if (showBackButton) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            }
        )
        HorizontalDivider(color = Gray100, thickness = 1.dp) // Garis pemisah
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithLogo(navController: NavController) {
    Column {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .padding(end = 24.dp)
                            .background(color = Color.White),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_with_text),
                            contentDescription = null,
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_notification_filled),
                            contentDescription = null,
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .clickable {
                                    navController.navigate(Screen.NotificationScreen.route)
                                }
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.White
            )
        )
        HorizontalDivider(color = Gray100, thickness = 1.dp) // Garis pemisah
    }
}
