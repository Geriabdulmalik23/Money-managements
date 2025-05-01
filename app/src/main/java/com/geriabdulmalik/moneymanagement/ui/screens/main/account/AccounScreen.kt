package com.geriabdulmalik.moneymanagement.ui.screens.main.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.components.ShimmerEffect
import com.geriabdulmalik.moneymanagement.ui.components.TopBarWithDivider
import com.geriabdulmalik.moneymanagement.ui.components.getAdaptiveSize
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.handle
import com.geriabdulmalik.moneymanagement.ui.screens.main.home.WalletInfo
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.Red100
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder

@Composable
fun AccountScreen(mAccountViewModel: AccountViewModel = hiltViewModel()) {

    val mUserDataState by mAccountViewModel.mUserData.collectAsState()

    val isLoading = remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        TopBarWithDivider(title = "Account")
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(14.dp))

            mUserDataState.handle(
                onSuccess = { data ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1.0f),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_profile_example),
                                contentDescription = null,
                                modifier = Modifier.size(
                                    getAdaptiveSize(
                                        small = 60.dp, medium = 60.dp, large = 60.dp
                                    )
                                )
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(
                                modifier = Modifier,
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = data.name,
                                    style = AppTypography.bodyLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = Black70,
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = data.email,
                                    style = AppTypography.bodySmall,
                                    fontWeight = FontWeight.W500,
                                    color = Gray90,
                                    modifier = Modifier.placeholder(
                                        visible = false,
                                        highlight = PlaceholderHighlight.shimmer()
                                    )
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                        ) {
                            Button(
                                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                                    containerColor = ColorPrimary
                                ), shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "Edit Profile",
                                    style = AppTypography.labelMedium,
                                    fontWeight = FontWeight.W500
                                )
                            }

                        }
                    }
                },
                onLoading = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator()
                    }
                },
                onError = {

                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            WalletInfo()

            Spacer(modifier = Modifier.height(14.dp))

            HorizontalDivider(color = Gray100, thickness = 6.dp)

            Spacer(modifier = Modifier.height(28.dp))

            PanelSettings(icon = painterResource(id = R.drawable.ic_lockon_stroke_default),
                title = "Security",
                onClick = {})

            PanelSettings(icon = painterResource(id = R.drawable.ic_wallet_stroke_default),
                title = "Withdrawal Account",
                onClick = {})

            PanelSettings(icon = painterResource(id = R.drawable.ic_cog_stroke_default),
                title = "Settings",
                onClick = {})

            PanelSettings(icon = painterResource(id = R.drawable.ic_bubble_chat_circle_question_stroke_default),
                title = "Help Center",
                onClick = {})

            PanelSettings(icon = painterResource(id = R.drawable.ic_bubble_chat_text_stroke_default),
                title = "FAQ",
                onClick = {})

            PanelSettings(icon = painterResource(id = R.drawable.ic_sign_out_out_stroke_defaulti),
                title = "Logout",
                isLogout = true,
                onClick = {})

//            ShimmerEffect(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(Color.LightGray, RoundedCornerShape(50)),
//                durationMillis = 1000
//            )
        }
    }
}

@Composable
fun PanelSettings(icon: Painter, title: String, isLogout: Boolean = false, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 24.dp, end = 24.dp, bottom = 24.dp
            ), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = icon, contentDescription = null, tint = if (isLogout) Red100 else Black70)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = AppTypography.bodySmall,
            color = if (isLogout) Red100 else Black70,
            fontWeight = FontWeight.W400,
            modifier = Modifier
                .padding(vertical = 14.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun shimmerLoading() {
    ShimmerEffect(modifier = Modifier, durationMillis = 1000)
}

@Preview
@Composable
fun AccountScreenPrev() {
    AccountScreen()
}