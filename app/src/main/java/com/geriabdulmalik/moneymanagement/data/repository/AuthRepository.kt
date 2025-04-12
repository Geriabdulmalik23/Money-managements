package com.geriabdulmalik.moneymanagement.data.repository

import com.geriabdulmalik.moneymanagement.data.model.AuthResponse
import com.geriabdulmalik.moneymanagement.data.local.AuthPreferences
import com.geriabdulmalik.moneymanagement.data.model.BodyResponse
import com.geriabdulmalik.moneymanagement.data.remote.AuthService
import com.geriabdulmalik.moneymanagement.utils.ApiResult
import com.geriabdulmalik.moneymanagement.utils.parseError
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException

import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService,
    private val authPreferences: AuthPreferences
) {

    fun getToken(): Flow<String?> {
        return authPreferences.token
    }

    suspend fun authLogin(email: String, password: String): ApiResult<BodyResponse> {
        return try {
            val emailRequestBody = email.toRequestBody("text/plain".toMediaTypeOrNull())
            val passwordRequestBody = password.toRequestBody("text/plain".toMediaTypeOrNull())

            val response =
                authService.authLogin(email = emailRequestBody, password = passwordRequestBody)
            if (response.success) {
                authPreferences.saveToken(response.data.token.toString())
                ApiResult.Success(response.data)
            } else {
                ApiResult.Error(response.message)
            }

        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.parseError()
            ApiResult.Error(errorBody?.message ?: "Unknown error")
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Network error")
        }
    }

}