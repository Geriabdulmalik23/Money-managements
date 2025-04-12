package com.geriabdulmalik.moneymanagement.utils

import android.content.SharedPreferences
import javax.inject.Inject

class TokenManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun getToken(): String? {
        return sharedPreferences.getString("jwt_token", null)
    }

    fun saveToken(token: String) {
        sharedPreferences.edit().putString("jwt_token", token).apply()
    }
}