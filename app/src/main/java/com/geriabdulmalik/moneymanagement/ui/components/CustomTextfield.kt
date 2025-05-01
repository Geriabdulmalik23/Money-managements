package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geriabdulmalik.moneymanagement.ui.theme.Gray90
import com.geriabdulmalik.moneymanagement.ui.theme.Red100
import com.geriabdulmalik.moneymanagement.ui.theme.White90

//@Composable
//fun CustomTextField(
//    modifier: Modifier = Modifier,
//    placeholder: String,
//    values: String = "",
//    leadingIcon: (@Composable (() -> Unit))? = null,
//    trailingIcon: (@Composable (() -> Unit))? = null,
//    isReadOnly: Boolean = false,
//    onValue: (String) -> Unit
//) {
//
//    val textValue = remember {
//        mutableStateOf(values)
//    }
//
//    Box(modifier = modifier) {
//        TextField(
//            value = textValue.value,
//            onValueChange = {
//                textValue.value = it
//                onValue(it)
//            },
//            placeholder = {
//                CustomTextMedium(
//                    text = placeholder,
//                    color = Gray90,
//                    modifier = Modifier.fillMaxWidth()
//                )
//            },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Email
//            ),
//            colors = TextFieldDefaults.colors(
//                unfocusedContainerColor = White90,
//                focusedContainerColor = White90,
//                unfocusedIndicatorColor = White90,
//                focusedIndicatorColor = White90
//            ),
//            readOnly = isReadOnly,
//            shape = RoundedCornerShape(8.dp),
//            singleLine = true,
//            leadingIcon = leadingIcon?.let { { it() } },
//            trailingIcon = trailingIcon?.let { { it() } }
//        )
//    }
//}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: (@Composable (() -> Unit))? = null,
    trailingIcon: (@Composable (() -> Unit))? = null,
    isReadOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Text
    ),
    isError: Boolean = false,
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isEnable: Boolean = true
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.pointerInput(Unit) {},
        placeholder = {
            CustomTextMedium(
                text = placeholder,
                color = Gray90,
                fontWeight = FontWeight.W400,
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = White90,
            focusedContainerColor = White90,
            unfocusedIndicatorColor = White90,
            focusedIndicatorColor = if (isError) Red100 else White90,
            errorContainerColor = White90,
            disabledContainerColor = White90,
            disabledIndicatorColor = White90
        ),
        readOnly = isReadOnly,
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        textStyle = LocalTextStyle.current.copy(
            fontSize = 14.sp // Ukuran font lebih kecil
        ),
        enabled = isEnable
    )

    if (isError && !errorMessage.isNullOrBlank()) {
        CustomTextMedium(
            text = errorMessage,
            color = Red100,
            modifier = Modifier.padding(top = 2.dp),
            fontSize = 12.sp
        )
    }
}

//keyboardOptions = KeyboardOptions.Default.copy(
//keyboardType = KeyboardType.Password
//),
//visualTransformation = PasswordVisualTransformation(),