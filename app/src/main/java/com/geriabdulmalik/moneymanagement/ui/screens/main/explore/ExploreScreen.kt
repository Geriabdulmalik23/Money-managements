package com.geriabdulmalik.moneymanagement.ui.screens.main.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithDivider
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.White90

@Composable
fun ExploreScreen() {

    val searchText = remember {
        mutableStateOf("")
    }

    Scaffold(topBar = { TopBarWithDivider(title = "Explore") }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Box(modifier = Modifier.padding(horizontal = 20.dp)) {
                TextField(value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                    },
                    placeholder = {
                        Text(
                            "Search", style = AppTypography.bodySmall, color = Gray90
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    ),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White90,
                        focusedContainerColor = White90,
                        unfocusedIndicatorColor = White90,
                        focusedIndicatorColor = White90
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_stroke_default),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    })
            }
            GridScreen()
        }
    }
}

@Composable
fun GridScreen() {
    val items = List(10) { "Item $it" } // Dummy data

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // 2 kolom (bisa diubah)
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items.size) { index ->
            GridItem(name = items[index])
        }
    }
}

@Composable
fun GridItem(name: String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier.padding(end = 12.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.img_mobile_legends),
                    contentDescription = null,
                    modifier = Modifier
                        .width(106.dp)
                        .height(183.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = name,
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