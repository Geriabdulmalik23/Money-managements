package com.geriabdulmalik.moneymanagement.utils

import android.util.Log
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun validateEmail(email: String): String? {
    return when {
        email.isBlank() -> "Email tidak boleh kosong"
        !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Email tidak valid"
        else -> null
    }
}

fun validatePassword(password: String): String? {
    return when {
        password.isBlank() -> "Password tidak boleh kosong"
        password.length < 3 -> "Password minimal 8 karakter"
        else -> null
    }
}

fun getFormattedNumber(number: Double): String {
    val symbols = DecimalFormatSymbols(Locale.GERMANY).apply {
        groupingSeparator = '.'
        decimalSeparator = ','
    }
    val decimalFormat = DecimalFormat("#,###", symbols)
    return decimalFormat.format(number)
}