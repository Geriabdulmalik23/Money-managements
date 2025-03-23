package com.geriabdulmalik.moneymanagement.ui.screens.onboarding.onboarding

import android.text.style.AlignmentSpan
import android.widget.Space
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.navigation.Screen
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary

@Composable
fun OnboardingScreen(navController: NavController) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier
            .width(screenWidth)
            .height(screenHeight)
            .background(color = Color.White)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight/1.5f),
            painter = painterResource(id = R.drawable.onboarding2),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "spend smarter\n save more",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = ColorPrimary
        )
        Spacer(modifier = Modifier.height(26.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp), colors = ButtonDefaults.buttonColors(
            containerColor = ColorPrimary
        ), onClick = {
            navController.navigate(Screen.LoginScreen.route)
        }) {
            Text(
                text = "Get Started",
                color = Color.White,
                modifier = Modifier.padding(vertical = 14.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Already have account?")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Log In", color = ColorPrimary)
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPrev() {
    OnboardingScreen(navController = rememberNavController())
}