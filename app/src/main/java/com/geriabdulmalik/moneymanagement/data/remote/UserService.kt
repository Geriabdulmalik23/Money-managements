package com.geriabdulmalik.moneymanagement.data.remote

import com.geriabdulmalik.moneymanagement.data.model.CheckPriceResponse
import com.geriabdulmalik.moneymanagement.data.model.HomeResponse
import com.geriabdulmalik.moneymanagement.data.model.OrderResultResponse
import com.geriabdulmalik.moneymanagement.data.model.PaymentMethodResponse
import com.geriabdulmalik.moneymanagement.data.model.ProductItemResponse
import com.geriabdulmalik.moneymanagement.data.model.ProductResponse
import com.geriabdulmalik.moneymanagement.data.model.UserResponse
import com.geriabdulmalik.moneymanagement.utils.BaseResponse
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface UserService {

    @GET("me")
    suspend fun getProfile(): BaseResponse<UserResponse>

    @GET("product")
    suspend fun getProduct(): BaseResponse<HomeResponse>

    @Multipart
    @POST("order/create")
    suspend fun createOrder(
        @Part("product_id") productId: RequestBody,
        @Part("product_option_id") optionId: RequestBody,
        @Part("payment_method_id") methodId: RequestBody,
        @Part("game_id") gameId: RequestBody,
        @Part("server") server: RequestBody
    ): BaseResponse<OrderResultResponse>

    @GET("order/check")
    suspend fun checkPrice(
        @Query("item_id") itemId: Int
    ): BaseResponse<CheckPriceResponse>

    @GET("product/item")
    suspend fun getProductItem(
        @Query("product_id") productId: Int
    ): BaseResponse<List<ProductItemResponse>>

    @GET("payments")
    suspend fun getPaymentMethod(): BaseResponse<List<PaymentMethodResponse>>

    @GET("logout")
    suspend fun logout(): BaseResponse<Unit>

}