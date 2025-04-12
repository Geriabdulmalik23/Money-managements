package com.geriabdulmalik.moneymanagement.data.remote

import com.geriabdulmalik.moneymanagement.data.model.UserResponse
import com.geriabdulmalik.moneymanagement.utils.BaseResponse
import retrofit2.http.GET

interface UserService {

    @GET("user/profile")
    suspend fun getProfile(): BaseResponse<UserResponse>

}