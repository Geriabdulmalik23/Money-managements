package com.geriabdulmalik.moneymanagement.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.geriabdulmalik.moneymanagement.ui.theme.Red100

@Composable
fun ValidatedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    validator: (String) -> String?,
    isValidatorPassword: Boolean = false
) {
    val error = validator(value)

    CustomTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = label,
        isError = error != null,
        errorMessage = error,
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (isValidatorPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}