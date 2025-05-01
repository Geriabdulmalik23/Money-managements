package com.geriabdulmalik.moneymanagement.ui.screens.main.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import com.geriabdulmalik.moneymanagement.domain.model.FeatureModel
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithLogo
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.Blue90
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100
import com.geriabdulmalik.moneymanagement.ui.theme.White90

@Composable
fun HomeScreen(navController: NavController) {


    val featureGame = listOf<FeatureModel>(
        FeatureModel(
            title = "Mobile Legend",
            image = painterResource(id = R.drawable.ic_game_mobile_legends),
            route = "order"
        ), FeatureModel(
            title = "Free Fire",
            image = painterResource(id = R.drawable.ic_game_free_fire),
            route = ""
        ), FeatureModel(
            title = "Honor Of Kings",
            image = painterResource(id = R.drawable.ic_game_honor_of_kings),
            route = ""
        ), FeatureModel(
            title = "Auto Chess",
            image = painterResource(id = R.drawable.ic_game_auto_chess),
            route = ""
        ),
        FeatureModel(
            title = "see",
            image = painterResource(id = R.drawable.ic_menu_stroke_filled),
            route = ""
        )
    )

    val featureTopUp = listOf(
        FeatureModel(
            title = "Shopee Pay",
            image = painterResource(id = R.drawable.ic_wallet_spay),
            route = ""
        ), FeatureModel(
            title = "Gopay", image = painterResource(id = R.drawable.ic_wallet_gopay), route = ""
        ), FeatureModel(
            title = "Dana", image = painterResource(id = R.drawable.ic_wallet_dana), route = ""
        ), FeatureModel(
            title = "OVO", image = painterResource(id = R.drawable.ic_wallet_ovo), route = ""
        ),
        FeatureModel(
            title = "see",
            image = painterResource(id = R.drawable.ic_menu_stroke_filled),
            route = ""
        )
    )

    val featureMobileCredit = listOf(
        FeatureModel(
            title = "by.U", image = painterResource(id = R.drawable.ic_provider_byu), route = ""
        ), FeatureModel(
            title = "Telkomsel",
            image = painterResource(id = R.drawable.ic_provider_telkomsel),
            route = ""
        ), FeatureModel(
            title = "Indosat",
            image = painterResource(id = R.drawable.ic_provider_indosat),
            route = ""
        ), FeatureModel(
            title = "Axis", image = painterResource(id = R.drawable.ic_provider_axis), route = ""
        ),
        FeatureModel(
            title = "see",
            image = painterResource(id = R.drawable.ic_menu_stroke_filled),
            route = ""
        )
    )

    Scaffold(topBar = {
        TopBarWithLogo(navController = navController)

    }) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
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

            FeatureRecommendation("Game Recommendation", items = featureGame) {
                navController.navigate(it)
            }

            Spacer(modifier = Modifier.height(24.dp))

            FeatureRecommendation("Top Up E-Wallet", items = featureTopUp) {

            }

            Spacer(modifier = Modifier.height(24.dp))

            FeatureRecommendation("Top up Mobile Credit", items = featureMobileCredit) {

            }

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
fun FeatureRecommendation(
    title: String = "Game Recommendation",
    items: List<FeatureModel>,
    onItemClick: (String) -> Unit
) {
    Column(modifier = Modifier.padding(start = 24.dp)) {
        Text(
            text = title,
            style = AppTypography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black70,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(end = 24.dp)
        ) {
            items(items) {
                when (it.title) {

                    "see" -> MoreFeature()

                    else -> {
                        Column(
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .clickable {
                                    onItemClick(it.route)
                                },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = it.image,
                                contentDescription = null,
                                modifier = Modifier.size(width = 100.dp, height = 140.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = it.title,
                                style = AppTypography.bodySmall,
                                fontWeight = FontWeight.W400,
                                color = Black70,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MoreFeature() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .size(width = 100.dp, height = 140.dp)
                .background(
                    shape = RoundedCornerShape(
                        8.dp
                    ), color = Blue90
                ), contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_stroke_filled),
                contentDescription = null,
                tint = ColorPrimary
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "See All",
            style = AppTypography.bodySmall,
            fontWeight = FontWeight.W400,
            color = ColorPrimary,
        )
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
//    MoreFeature()
}