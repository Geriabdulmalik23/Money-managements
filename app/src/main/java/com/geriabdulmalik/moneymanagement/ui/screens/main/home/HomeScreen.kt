package com.geriabdulmalik.moneymanagement.ui.screens.main.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.data.model.ProductResponse
import com.geriabdulmalik.moneymanagement.ui.components.CustomDialog
import com.geriabdulmalik.moneymanagement.ui.components.ShimmerEffect
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithLogo
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.handle
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.Blue90
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingLarge
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingMedium
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingMini
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingSmall
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100
import com.geriabdulmalik.moneymanagement.ui.theme.White90
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {

    val mProductDataState by homeViewModel.mProduct.collectAsStateWithLifecycle()

    var clover by remember { mutableStateOf(0) }
    var energy by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }

    fun handleProductClick(product: ProductResponse) {
        if (product.isMaintenance == 1) showDialog = true
        else navController.navigate("order/${product.id}")
    }

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
            Spacer(modifier = Modifier.height(PaddingSmall))

            WalletInfo(clover = clover, energy = energy)

            Spacer(modifier = Modifier.height(PaddingSmall))

            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            CardFeature(onItemClick = {
                showDialog = it
            })

            mProductDataState.handle(onLoading = {

                PlaceholderSection(
                    titles = listOf(
                        "Game Recommendation", "Top Up E-Wallet", "Top up Mobile Credit"
                    )
                )

            }, onSuccess = {

                it.balance?.clover?.let { cl -> clover = cl }
                energy = it.balance?.energy ?: 0

                FeatureRecommendation(
                    "Game Recommendation",
                    items = it.game,
                    onItemClick = ::handleProductClick
                )
                Spacer(modifier = Modifier.height(PaddingLarge))

                FeatureRecommendation(
                    "Top Up E-Wallet",
                    items = it.eWallet,
                    onItemClick = ::handleProductClick
                )

                Spacer(modifier = Modifier.height(PaddingLarge))

                FeatureRecommendation(
                    "Top up Mobile Credit",
                    items = it.mobileCredit,
                    onItemClick = ::handleProductClick
                )

            }, onError = {

                PlaceholderSection(
                    titles = listOf(
                        "Game Recommendation", "Top Up E-Wallet", "Top up Mobile Credit"
                    )
                )

            })

            if (showDialog) {
                CustomDialog(
                    title = "Oops!",
                    message = "This product is being fixed right now. Please check back soon!",
                    isSuccess = false
                ) {
                    showDialog = false
                }
            }
        }
    }
}

@Composable
fun PlaceholderSection(titles: List<String>) {
    titles.forEach {
        ShimmerProduct(title = it)
        Spacer(modifier = Modifier.height(PaddingLarge))
    }
}

@Composable
fun CardFeature(onItemClick: (Boolean) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-20).dp)
            .padding(horizontal = PaddingLarge),
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
                .padding(horizontal = PaddingMedium, vertical = PaddingSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.clickable { onItemClick(true) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_game),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                Text(
                    text = "Game",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.clickable { onItemClick(true) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_e_wallet),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                Text(
                    text = "E-Wallet",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.clickable { onItemClick(true) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_apps),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                Text(
                    text = "Apps",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.clickable { onItemClick(true) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_credit),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(PaddingMini))
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
    items: List<ProductResponse>,
    onItemClick: (ProductResponse) -> Unit
) {
    Column(modifier = Modifier.padding(start = PaddingLarge)) {
        Text(
            text = title,
            style = AppTypography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black70,
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        LazyRow(
            contentPadding = PaddingValues(end = PaddingLarge)
        ) {
            items(items) {
                Column(
                    modifier = Modifier
                        .padding(end = PaddingSmall)
                        .clickable {
                            onItemClick(it)
                        }, horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = it.imageUrl,
                        contentDescription = null,
                        modifier = Modifier.size(width = 100.dp, height = 140.dp)
                    )

                    Spacer(modifier = Modifier.height(PaddingMini))
                    Text(
                        text = it.name!!,
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400,
                        color = Black70,
                    )
                }
            }

            item {
                MoreFeature()
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
                        PaddingMini
                    ), color = Blue90
                ), contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_stroke_filled),
                contentDescription = null,
                tint = ColorPrimary
            )
        }
        Spacer(modifier = Modifier.height(PaddingMini))
        Text(
            text = "See All",
            style = AppTypography.bodySmall,
            fontWeight = FontWeight.W400,
            color = ColorPrimary,
        )
    }
}

@Composable
fun WalletInfo(clover: Int = 0, energy: Int = 0) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = PaddingLarge),
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
                    .width(PaddingLarge)
                    .height(PaddingLarge)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(PaddingMini))
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
                    text = "$clover",
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
                    .width(PaddingLarge)
                    .height(PaddingLarge)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(PaddingMini))
            Column {
                Text(
                    text = "Energy",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$energy",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W500,
                    color = Black70
                )
            }
        }
    }
}

@Composable
fun ShimmerProduct(title: String) {
    Column(
        modifier = Modifier.padding(start = PaddingLarge),
    ) {
        Text(
            text = title,
            style = AppTypography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black70,
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            repeat(4) {
                Column(
                    modifier = Modifier.padding(end = PaddingSmall),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ShimmerEffect(
                        modifier = Modifier
                            .size(width = 100.dp, height = 140.dp)
                            .background(Color.LightGray, RoundedCornerShape(PaddingMini)),
                        durationMillis = 1000
                    )
                    Spacer(modifier = Modifier.height(PaddingMini))
                    Text(
                        text = "Loading...",
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.placeholder(
                            visible = false, highlight = PlaceholderHighlight.shimmer()
                        )
                    )
                }
            }
            MoreFeature()
        }

    }
}

@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen(navController = rememberNavController())
}