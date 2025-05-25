package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.geriabdulmalik.moneymanagement.R
import com.geriabdulmalik.moneymanagement.ui.theme.ColorPrimary
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingExtraMedium
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingLarge
import com.geriabdulmalik.moneymanagement.ui.theme.Dimens.PaddingMedium
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.Red100

@Composable
fun CustomDialog(
    isSuccess: Boolean = false,
    title: String,
    message: String,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = {
        onDismiss()
    }) {
        Card(
            shape = RoundedCornerShape(PaddingMedium), colors = CardDefaults.cardColors(
                contentColor = Color.White,
                containerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = PaddingExtraMedium, vertical = PaddingLarge)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = if (isSuccess) R.drawable.ic_checklist_blue else R.drawable.ic_alert_red),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextMedium(text = title, fontWeight = FontWeight.W500, color = Color.Black)

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextMedium(text = message, color = Gray90)

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        onDismiss()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RoundedCornerShape(Dimens.PaddingMini),
                    colors = ButtonDefaults.buttonColors(containerColor = if (isSuccess) ColorPrimary else Red100)
                ) {
                    Text("OK", color = Color.White)
                }


            }
        }
    }
}

@Preview
@Composable
fun CustomDialogPrev() {
    CustomDialog(title = "Success", isSuccess = false, message = "Message") {

    }
}