package com.geriabdulmalik.moneymanagement.ui.screens.main.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.domain.model.FeatureModel
import com.geriabdulmalik.moneymanagement.ui.components.CategoryFilter
import com.geriabdulmalik.moneymanagement.ui.components.CustomTextField
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithDivider
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.HighTextField
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.White90

@Composable
fun ExploreScreen() {

    val searchText = remember {
        mutableStateOf("")
    }
    val categoryList = listOf("Game", "E-Wallet", "Apps", "Pulsa")
    var selectedCategory by remember { mutableStateOf(0) }


    Scaffold(topBar = { TopBarWithDivider(title = "Explore") }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(HighTextField),
                placeholder = "Search",
                onValueChange = { searchText.value = it },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search_stroke_default),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                },
                value = searchText.value
            )
//            Box(modifier = Modifier.padding(horizontal = 24.dp)) {
//                TextField(value = searchText.value,
//                    onValueChange = {
//                        searchText.value = it
//                    },
//                    placeholder = {
//                        Text(
//                            "Search", style = AppTypography.bodySmall, color = Gray90
//                        )
//                    },
//                    modifier = Modifier.fillMaxWidth(),
//                    keyboardOptions = KeyboardOptions.Default.copy(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    colors = TextFieldDefaults.colors(
//                        unfocusedContainerColor = White90,
//                        focusedContainerColor = White90,
//                        unfocusedIndicatorColor = White90,
//                        focusedIndicatorColor = White90
//                    ),
//                    shape = RoundedCornerShape(8.dp),
//                    singleLine = true,
//                    leadingIcon = {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_search_stroke_default),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .width(20.dp)
//                                .height(20.dp)
//                        )
//                    })
//            }
            Spacer(modifier = Modifier.height(18.dp))

            CategoryFilter(
                categories = categoryList,
                selectedIndex = selectedCategory,
                onSelectedChanged = { selectedCategory = it }
            )
            Spacer(modifier = Modifier.height(24.dp))

            GridScreen()
        }
    }
}

@Composable
fun GridScreen() {

    val featureGame = listOf(
        FeatureModel(
            title = "Mobile Legend",
            image = painterResource(id = R.drawable.ic_game_mobile_legends),
            route = ""
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
            title = "PUBG Mobile",
            image = painterResource(id = R.drawable.ic_game_pubg),
            route = ""
        ),
        FeatureModel(
            title = "UNDAWN",
            image = painterResource(id = R.drawable.ic_game_undawn),
            route = ""
        ),
        FeatureModel(
            title = "Point Blank",
            image = painterResource(id = R.drawable.ic_game_point_blank),
            route = ""
        ),
        FeatureModel(
            title = "Lords Mobile",
            image = painterResource(id = R.drawable.ic_game_lords_mobile),
            route = ""
        ),
        FeatureModel(
            title = "Ragnarock",
            image = painterResource(id = R.drawable.ic_game_ragnarok_origin),
            route = ""
        ),
        FeatureModel(
            title = "Domino Island",
            image = painterResource(id = R.drawable.ic_game_domino),
            route = ""
        ),
        FeatureModel(
            title = "Hero Clash",
            image = painterResource(id = R.drawable.ic_game_hero_clash),
            route = ""
        ),
        FeatureModel(
            title = "SuperSus",
            image = painterResource(id = R.drawable.ic_game_supersus),
            route = ""
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(featureGame) {
            GridItem(featureModel = it)
        }
    }
}

@Composable
fun GridItem(featureModel: FeatureModel) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = featureModel.image,
                    contentDescription = null,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = featureModel.title,
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Black70,
                )
            }
        }
    }
}

@Preview
@Composable
fun ExploreScreenPrev() {
    ExploreScreen()
}