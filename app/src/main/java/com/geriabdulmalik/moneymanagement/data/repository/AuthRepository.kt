package com.geriabdulmalik.moneymanagement.data.repository

import com.geriabdulmalik.moneymanagement.data.model.AuthResponse
import com.geriabdulmalik.moneymanagement.data.local.AuthPreferences
import com.geriabdulmalik.moneymanagement.data.remote.AuthService
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService,
    private val authPreferences: AuthPreferences
) {

    fun getToken(): Flow<String?> {
        return authPreferences.token
    }

    suspend fun saveToken(token: String) {
        authPreferences.saveToken(token)
    }

    suspend fun clearToken(token: String) {
        authPreferences.clearToken(token)
    }

    suspend fun authLogin(email: String, password: String): AuthResponse {
        val emailRequestBody = email.toRequestBody("text/plain".toMediaTypeOrNull())
        val passwordRequestBody = password.toRequestBody("text/plain".toMediaTypeOrNull())

        val response =
            authService.authLogin(email = emailRequestBody, password = passwordRequestBody)

        if (response.status) {
            response.data.let {
                authPreferences.saveToken(it.token.toString())
            }
        }

        return response
    }

}