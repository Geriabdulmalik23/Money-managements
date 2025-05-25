package com.geriabdulmalik.moneymanagement.ui.screens.order

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.data.model.CheckPriceResponse
import com.geriabdulmalik.moneymanagement.data.model.CreateOrderRequest
import com.geriabdulmalik.moneymanagement.data.model.PaymentMethodResponse
import com.geriabdulmalik.moneymanagement.data.model.ProductItemResponse
import com.geriabdulmalik.moneymanagement.ui.components.CustomBottomSheet
import com.geriabdulmalik.moneymanagement.ui.components.CustomTextField
import com.geriabdulmalik.moneymanagement.ui.components.CustomTextMedium
import com.geriabdulmalik.moneymanagement.ui.components.DashedLine
import com.geriabdulmalik.moneymanagement.ui.components.LoadingDialog
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithDivider
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.ResultState
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.handle
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.ColorSuccess
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.HighTextField
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingLarge
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingMedium
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingMini
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingSmall
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.utils.getFormattedNumber
import com.geriabdulmalik.moneymanagement.utils.getParsingNumber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(navController: NavController) {
    val bottomSheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Expanded
    )
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState)

    val viewModel: OrderViewModel = hiltViewModel()

    BottomSheetScaffold(scaffoldState = scaffoldState, sheetPeekHeight = 90.dp, sheetContent = {
        BottomSheetDetailContent(viewModel = viewModel, navController = navController)
    }, topBar = {
        TopBarWithDivider(title = "Top Up Game", showBackButton = true) {
            navController.popBackStack()
        }
    }, sheetContainerColor = Color.White, sheetTonalElevation = 1.dp, sheetDragHandle = {
        Box(
            Modifier
                .padding(vertical = PaddingMini)
                .size(width = 40.dp, height = 4.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Gray100)
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(PaddingLarge))

            FeatureGameSection(viewModel = viewModel)
        }
    }
}

@Composable
fun BottomSheetItemDetail(checkPriceResponse: CheckPriceResponse?) {
    Column {
        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                CustomTextMedium(text = "Payment Method", color = Gray90)
                Spacer(modifier = Modifier.height(PaddingMini))
                CustomTextMedium(
                    text = "${checkPriceResponse?.productName}",
                    fontWeight = FontWeight.Bold,
                    color = Gray90
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                Row {
                    CustomTextMedium(text = "VAT", color = Gray90)
                    Spacer(modifier = Modifier.width(2.dp))
                    CustomTextMedium(
                        text = " ${checkPriceResponse?.vat ?: "0"}%",
                        color = Color.Red
                    )
                }
                Spacer(modifier = Modifier.height(PaddingMini))
                Row {
                    CustomTextMedium(text = "Promo", color = Gray90)
                    Spacer(modifier = Modifier.width(2.dp))
                    CustomTextMedium(
                        text = " ${checkPriceResponse?.discount ?: "0"}%",
                        color = ColorPrimary
                    )
                }
                Spacer(modifier = Modifier.height(PaddingMini))
                CustomTextMedium(text = "Total Price", color = Gray90)
            }
            Column(horizontalAlignment = Alignment.End) {
                CustomTextMedium(
                    text = "QRIS", color = Color.Black, fontWeight = FontWeight.W500
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                CustomTextMedium(
                    text = getParsingNumber(checkPriceResponse?.productPrice!!),
                    color = ColorSuccess,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                CustomTextMedium(
                    text = "RP${checkPriceResponse.totalVat ?: "RP0"}",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                CustomTextMedium(
                    text = "RP${checkPriceResponse.totalDiscount ?: "RP0"}",
                    color = ColorPrimary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(PaddingMini))
                CustomTextMedium(
                    text = "Rp${checkPriceResponse.totalPrice ?: "RP0"}",
                    color = ColorSuccess,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(PaddingMedium))
    }
}

@Composable
fun BottomSheetDetailContent(viewModel: OrderViewModel, navController: NavController) {
    var isShowFullDetail by remember { mutableStateOf(false) }
    var isCompleteFilled by remember { mutableStateOf(false) }
    val mCheckPriceDataState by viewModel.mCheckPrice.collectAsStateWithLifecycle()
    val mOrderResultDataState by viewModel.mOrderResult.collectAsStateWithLifecycle()
    val isLoading = mOrderResultDataState is ResultState.Loading
    var mCheckPriceResult by remember { mutableStateOf<CheckPriceResponse?>(null) }

    mCheckPriceDataState.handle(
        onSuccess = {
            mCheckPriceResult = it
            isCompleteFilled = true
        },
        onLoading = {
            isCompleteFilled = false
        },
        onError = {
            isCompleteFilled = false
        }
    )

    mOrderResultDataState.handle(
        onSuccess = {
            navController.navigate("detail")
        },
    )
    LoadingDialog(isLoading = isLoading) {}

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = PaddingLarge, vertical = PaddingMedium)
    ) {
        if (isCompleteFilled) {
            Spacer(modifier = Modifier.height(PaddingSmall))

            Row(
                Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    CustomTextMedium(text = "Item Selected", color = Gray90)
                    Spacer(modifier = Modifier.height(PaddingMini))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_diamond_blue),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        CustomTextMedium(
                            text = "${mCheckPriceResult?.productName}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.End) {
                    CustomTextMedium(text = "Total Price", color = Gray90)
                    Spacer(modifier = Modifier.height(PaddingMini))
                    CustomTextMedium(
                        text = "RP${mCheckPriceResult?.productPrice?.let { getParsingNumber(it) }}",
                        color = ColorSuccess,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(PaddingMedium))
            DashedLine()
            Spacer(Modifier.height(PaddingMedium))

            if (isShowFullDetail) {
                AnimatedVisibility(
                    visible = isShowFullDetail,
                    enter = fadeIn() + expandVertically(expandFrom = Alignment.Top),
                    exit = fadeOut() + shrinkVertically(shrinkTowards = Alignment.Top)
                ) {
                    BottomSheetItemDetail(checkPriceResponse = mCheckPriceResult)
                }

                Text(
                    text = "Show less",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isShowFullDetail = false },
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline, color = ColorPrimary
                    )
                )
                Spacer(modifier = Modifier.height(PaddingMedium))
            } else {
                Text(
                    text = "See total price include VAT",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isShowFullDetail = true },
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline, color = ColorPrimary
                    )
                )
                Spacer(Modifier.height(PaddingMedium))
            }
        }


        Button(
            onClick = {

                val createOrder = CreateOrderRequest(
                    productId = "${mCheckPriceResult?.productId}",
                    gameId = "232123",
                    optionId = "1",
                    methodId = "1",
                    server = "2011"
                )
                viewModel.createOrder(
                    orderRequest = createOrder
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(HighTextField),
            shape = RoundedCornerShape(PaddingMini),
            colors = ButtonDefaults.buttonColors(containerColor = ColorPrimary),
            enabled = isCompleteFilled
        ) {
            Text("Buy", color = Color.White)
        }
    }
}

@Composable
fun FeatureGameSection(viewModel: OrderViewModel) {

    var gameIdText by remember { mutableStateOf("") }
    var zonaIdText by remember { mutableStateOf("") }
    var selectedItem by remember { mutableStateOf("") }
    var paymentMethod by remember { mutableStateOf("") }
    var promotionCode by remember { mutableStateOf("") }
    var isSelectedItem by remember { mutableStateOf(false) }
    var isSelectedPaymentMethod by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = PaddingLarge)
    ) {
        CustomTextMedium(
            text = "Game ID", fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(PaddingSmall))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(
                modifier = Modifier
                    .weight(1f)
                    .height(HighTextField),
                placeholder = "Game ID",
                onValueChange = { input ->
                    if (input.all { it.isDigit() }) {
                        gameIdText = input
                    }
                },
                value = gameIdText,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CustomTextField(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = PaddingMini)
                    .height(HighTextField),
                placeholder = "Zona ID",
                value = zonaIdText,
                onValueChange = { input ->
                    if (input.all { it.isDigit() }) {
                        zonaIdText = input
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(modifier = Modifier.height(PaddingLarge))
        CustomTextMedium(
            text = "Select Item", fontWeight = FontWeight.Bold, modifier = Modifier
        )
        Spacer(modifier = Modifier.height(PaddingSmall))
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isSelectedItem = true
            }
            .height(HighTextField)) {
            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(HighTextField),
                placeholder = "Select Item",
                onValueChange = { selectedItem = it },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_diamond_blue),
                        contentDescription = null,
                        modifier = Modifier.size(PaddingLarge)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null
                    )
                },
                isReadOnly = true,
                isEnable = false,
                value = selectedItem
            )
        }

        Spacer(modifier = Modifier.height(PaddingLarge))
        CustomTextMedium(text = "Payment Method", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(PaddingSmall))

        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(HighTextField)
                .clickable {
                    isSelectedPaymentMethod = true
                },
            placeholder = "Payment Method",
            onValueChange = { paymentMethod = it },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null
                )
            },
            isReadOnly = true,
            value = paymentMethod,
            isEnable = false
        )

        Spacer(modifier = Modifier.height(PaddingLarge))
        CustomTextMedium(text = "Promo Code", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(PaddingSmall))

        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(HighTextField),
            placeholder = "Promo Code",
            onValueChange = { promotionCode = it },
            value = promotionCode,
            isEnable = false,
            trailingIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null
                )
            }
        )

        Spacer(modifier = Modifier.height(PaddingSmall))

        CustomBottomSheet(open = isSelectedItem,
            onDismissRequest = { isSelectedItem = false },
            content = {

                val mProductItemState by viewModel.mProductItem.collectAsStateWithLifecycle()

                mProductItemState.handle(onSuccess = {
                    DiamondPackageListContent(diamondPackages = it, onItemSelected = { item ->
                        isSelectedItem = false
                        selectedItem = item.title
                        viewModel.checkPrice(item.id)
                    })
                }, onLoading = {
                    CircularProgressIndicator()
                })
            })

        CustomBottomSheet(open = isSelectedPaymentMethod,
            onDismissRequest = { isSelectedPaymentMethod = false },
            content = {
                val mPaymentMethodDataState by viewModel.mPaymentMethod.collectAsStateWithLifecycle()
                mPaymentMethodDataState.handle(
                    onLoading = {
                        CircularProgressIndicator()
                    },
                    onSuccess = {
                        paymentMethodList(list = it, onItemSelected = { payment ->
                            isSelectedPaymentMethod = false
                            paymentMethod = payment.name!!
                        })
                    }
                )

            })
    }
}


@Preview
@Composable
fun OrderScreenPrev() {
//    OrderScreen(navController = rememberNavController())
}

@Composable
fun DiamondPackageListContent(
    diamondPackages: List<ProductItemResponse>, onItemSelected: (ProductItemResponse) -> Unit = {}
) {
    LazyColumn {
        items(diamondPackages) { item ->
            ListItem(headlineContent = {
                val cleanString = item.basePrice.toString().replace("[,.]".toRegex(), "")
                val parsed = cleanString.toDoubleOrNull() ?: 0.0
                val formattedString = getFormattedNumber(parsed)

                Column {
                    CustomTextMedium(
                        text = item.title, fontWeight = FontWeight.W500, color = Black70
                    )
                    Spacer(modifier = Modifier.height(PaddingMini))
                    CustomTextMedium(
                        text = "RP${formattedString}",
                        color = ColorSuccess,
                        fontWeight = FontWeight.Bold
                    )
                }
            }, leadingContent = {
                Image(
                    painter = painterResource(id = R.drawable.ic_diamond_blue),
                    contentDescription = null,
                    modifier = Modifier.size(PaddingLarge)
                )
            }, colors = ListItemDefaults.colors(
                containerColor = Color.White
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PaddingMini)
                .toggleable(
                    value = false, onValueChange = { onItemSelected(item) }, role = Role.Button
                )
            )
        }
    }
}

@Composable
fun paymentMethodList(
    list: List<PaymentMethodResponse>, onItemSelected: (PaymentMethodResponse) -> Unit = {}
) {
    LazyColumn {
        items(list) { item ->
            ListItem(
                headlineContent = {
                    Column {
                        CustomTextMedium(text = item.name!!)
                    }
                }, colors = ListItemDefaults.colors(
                    containerColor = Color.White
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = PaddingMini)
                    .toggleable(
                        value = false, onValueChange = { onItemSelected(item) }, role = Role.Button
                    )
            )
        }
    }
}