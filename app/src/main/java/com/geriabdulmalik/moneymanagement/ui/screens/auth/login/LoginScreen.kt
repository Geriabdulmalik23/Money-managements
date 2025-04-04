package com.geriabdulmalik.moneymanagement.ui.screens.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.navigation.Screen
import com.geriabdulmalik.moneymanagement.ui.components.LoadingDialog
import com.geriabdulmalik.moneymanagement.ui.components.getAdaptiveSize
import com.geriabdulmalik.moneymanagement.ui.theme.AppTypography
import com.geriabdulmalik.moneymanagement.ui.theme.Black70
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Gray100
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.MoneyManagementTheme
import com.geriabdulmalik.moneymanagement.ui.theme.White90


@Composable
fun LoginScreen(navController: NavController, authViewModel: LoginViewModel = hiltViewModel()) {

    val emailText = remember {
        mutableStateOf("")
    }
    val passwordText = remember {
        mutableStateOf("")
    }

    val resultState by authViewModel.resultState.collectAsState()
    val isLoading = resultState is ResultState.Loading
//    val isLoading by authViewModel.isLoading.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .size(getAdaptiveSize(small = 50.dp, medium = 60.dp, large = 80.dp))
            .background(color = ColorPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(55.dp))
        Text(
            text = "Welcome to",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            style = AppTypography.titleSmall,
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.height(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.logo_with_text),
            contentDescription = null,
            tint = Color.White
        )
        Spacer(modifier = Modifier.height(54.dp))
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(
                topEnd = 24.dp, topStart = 24.dp
            ),
            elevation = CardDefaults.elevatedCardElevation(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Email",
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.W500,
                    color = Black70
                )

                Spacer(modifier = Modifier.height(12.dp))

                TextField(
                    value = emailText.value,
                    onValueChange = {
                        emailText.value = it
                    },
                    placeholder = {
                        Text(
                            "Email", style = AppTypography.bodySmall, color = Gray90
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email
                    ),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White90,
                        focusedContainerColor = White90,
                        unfocusedIndicatorColor = White90,
                        focusedIndicatorColor = White90
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "Password", style = AppTypography.bodySmall, color = Black70)

                Spacer(modifier = Modifier.height(12.dp))

                TextField(
                    value = passwordText.value,
                    onValueChange = {
                        passwordText.value = it
                    },
                    placeholder = {
                        Text(
                            "Password", style = AppTypography.bodySmall, color = Gray90
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White90,
                        focusedContainerColor = White90,
                        unfocusedIndicatorColor = White90,
                        focusedIndicatorColor = White90
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Forgot Password ?",
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline, color = ColorPrimary
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        authViewModel.login(
                            email = emailText.value, password = passwordText.value
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ColorPrimary)
                ) {
                    Text(text = "Sign In", fontSize = 18.sp, style = AppTypography.bodySmall)
                }
                LoadingDialog(isLoading = isLoading) {}
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        color = Gray100, thickness = 1.dp, modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "Or sign in with",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Gray90,
                        textAlign = TextAlign.Center,
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400
                    )
                    HorizontalDivider(
                        color = Gray100, thickness = 1.dp, modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(width = 0.5.dp, color = Gray100),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Google",
                        color = Black70,
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(width = 0.5.dp, color = Gray100),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Facebook",
                        color = Black70,
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400
                    )
                }
                when (resultState) {
                    is ResultState.Success -> {
                        navController.navigate(Screen.MainScreen.route) {
                            popUpTo(0)
                        }
                    }

                    is ResultState.Error -> Text("Login Failed!")
                    else -> {}
                }
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don’t have an account?",
                        color = Gray90,
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Sign Up",
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.W400,
                        textDecoration = TextDecoration.Underline,
                        color = ColorPrimary
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPrev() {
    LoginScreen(navController = rememberNavController())
}