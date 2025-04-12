package com.geriabdulmalik.moneymanagement.data.repository

import com.geriabdulmalik.moneymanagement.data.model.UserResponse
import com.geriabdulmalik.moneymanagement.data.remote.UserService
import com.geriabdulmalik.moneymanagement.utils.ApiResult
import com.geriabdulmalik.moneymanagement.utils.parseError
import retrofit2.HttpException
import javax.inject.Inject

class UserRepository @Inject constructor(private val mUserService: UserService) {

    suspend fun getProfile(): ApiResult<UserResponse> {
        return try {
            val response = mUserService.getProfile()

            if (response.success) ApiResult.Success(response.data) else ApiResult.Error(response.message)

        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.parseError()
            ApiResult.Error(errorBody?.message ?: "Unknown error")
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Network error")
        }
    }
}