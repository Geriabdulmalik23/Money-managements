package com.geriabdulmalik.moneymanagement.data.remote
import com.geriabdulmalik.moneymanagement.data.model.AuthResponse
import com.geriabdulmalik.moneymanagement.data.model.BodyResponse
import com.geriabdulmalik.moneymanagement.utils.BaseResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AuthService {

    @Multipart
    @POST("auth/login")
    suspend fun authLogin(
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody
    ): BaseResponse<BodyResponse>

}