package com.geriabdulmalik.moneymanagement.ui.screens.main.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithLogo
import com.geriabdulmalik.moneymanagement.ui.components.getAdaptiveSize
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100
import com.geriabdulmalik.moneymanagement.ui.theme.White90

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(topBar = {
        TopBarWithLogo(navController = navController)

    }) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
                .size(getAdaptiveSize(small = 50.dp, medium = 60.dp, large = 80.dp))
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            WalletInfo()

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            CardFeature()

            GameRecommendation("Game Recommendation")

            Spacer(modifier = Modifier.height(24.dp))

            GameRecommendation("Top Up E-Wallet")

            Spacer(modifier = Modifier.height(24.dp))

            GameRecommendation("Application Vouchers")

            Spacer(modifier = Modifier.height(24.dp))

            GameRecommendation("Top up Mobile Credit")

        }
    }
}

@Composable
fun CardFeature() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-20).dp)
            .padding(horizontal = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        border = BorderStroke(color = White90, width = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_game),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Game",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_e_wallet),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "E-Wallet",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_apps),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Apps",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_credit),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Credit",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Composable
fun GameRecommendation(title: String = "Game Recommendation") {
    Column(modifier = Modifier.padding(start = 24.dp)) {
        Text(
            text = title,
            style = AppTypography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black70,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            repeat(5) {
                Column(modifier = Modifier.padding(end = 12.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.img_mobile_legends),
                        contentDescription = null,
                        modifier = Modifier
                            .width(100.dp)
                            .height(165.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Mobile Legends",
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400,
                        color = Black70,

                        )
                }
            }
        }
    }
}

@Composable
fun WalletInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.luck_green),
                contentDescription = null,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)
            ) {
                Text(
                    text = "Clover",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "10.000",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W500,
                    color = Black70
                )
            }
            Image(
                painter = painterResource(id = R.drawable.plus_circle_stroke_default),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.3f)
            )
        }
        Row(
            modifier = Modifier
                .width(1.dp)
                .weight(0.3f)
                .height(32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            VerticalDivider(
                color = Gray100, thickness = 1.dp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.flash_pirple),
                contentDescription = null,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Energy",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "400",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W500,
                    color = Black70
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen(navController = rememberNavController())
}