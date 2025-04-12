package com.geriabdulmalik.moneymanagement.utils

import androidx.compose.runtime.collectAsState
import com.geriabdulmalik.moneymanagement.data.local.AuthPreferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val mAuthPreferences: AuthPreferences
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = mAuthPreferences.getTokenSync()
        val newRequest = chain.request().newBuilder().apply {
            header("Authorization", "Bearer $token")
        }.build()
        return chain.proceed(newRequest)
    }
}