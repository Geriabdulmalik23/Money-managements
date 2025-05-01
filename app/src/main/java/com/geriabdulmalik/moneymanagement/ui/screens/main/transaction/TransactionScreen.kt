package com.geriabdulmalik.moneymanagement.ui.screens.main.transaction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.geriabdulmalik.moneymanagement.ui.components.getAdaptiveSize
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingLarge
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.White90

@Composable
fun TransactionScreen() {

    val searchText = remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        TopBarWithDivider(title = "Transaction")
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(color = Color.White)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(PaddingLarge))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = PaddingLarge),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1.0f)
                        .height(46.dp),
                    contentAlignment = Alignment.Center
                ) {
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
                Button(
                    modifier = Modifier
                        .weight(0.3f)
                        .width(45.dp)
                        .height(45.dp)
                        .padding(start = 8.dp),
                    onClick = {

                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ColorPrimary
                    ),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_filter_stroke_default),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.no_transaction_img),
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                        .height(160.dp)
                )
                Spacer(modifier = Modifier.height(PaddingLarge))
                Text(
                    text = "No Transactions Yet",
                    style = AppTypography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Black70
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "You have no transaction right now",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = Gray90
                )
            }
        }
    }
}

@Preview
@Composable
fun TransactionScreenPrev() {
    TransactionScreen()
}