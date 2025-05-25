package com.geriabdulmalik.moneymanagement.data.repository

import android.util.Log
import com.geriabdulmalik.moneymanagement.data.local.AuthPreferences
import com.geriabdulmalik.moneymanagement.data.model.AuthResponse
import com.geriabdulmalik.moneymanagement.data.model.CheckPriceResponse
import com.geriabdulmalik.moneymanagement.data.model.CreateOrderRequest
import com.geriabdulmalik.moneymanagement.data.model.HomeResponse
import com.geriabdulmalik.moneymanagement.data.model.OrderResultResponse
import com.geriabdulmalik.moneymanagement.data.model.PaymentMethodResponse
import com.geriabdulmalik.moneymanagement.data.model.ProductItemResponse
import com.geriabdulmalik.moneymanagement.data.model.UserResponse
import com.geriabdulmalik.moneymanagement.data.remote.UserService
import com.geriabdulmalik.moneymanagement.utils.ApiResult
import com.geriabdulmalik.moneymanagement.utils.parseError
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val mUserService: UserService,
    private val mAuthPreferences: AuthPreferences
) {

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

    suspend fun getProduct(): ApiResult<HomeResponse> {
        return try {
            val response = mUserService.getProduct()

            if (response.success) ApiResult.Success(response.data) else ApiResult.Error(response.message)
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.parseError()
            ApiResult.Error(errorBody?.message ?: "Unknown error")
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Network error")
        }
    }

    suspend fun getProductItem(productId: Int): ApiResult<List<ProductItemResponse>> {
        return try {
            val response = mUserService.getProductItem(productId = productId)

            if (response.success) ApiResult.Success(response.data) else ApiResult.Error(response.message)

        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.parseError()
            ApiResult.Error(errorBody?.message ?: "Unknown error")
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Network error")
        }
    }

    suspend fun getPaymentMethod(): ApiResult<List<PaymentMethodResponse>> {
        return try {
            val response = mUserService.getPaymentMethod()

            if (response.success) ApiResult.Success(response.data) else ApiResult.Error(response.message)

        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.parseError()
            ApiResult.Error(errorBody?.message ?: "Unknown error")
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Network error")
        }
    }

    suspend fun checkPrice(itemId: Int): ApiResult<CheckPriceResponse> {
        return try {
            val response = mUserService.checkPrice(itemId = itemId)

            if (response.success) ApiResult.Success(response.data) else ApiResult.Error(response.message)
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.parseError()
            ApiResult.Error(errorBody?.message ?: "Unknown error")
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Network error")
        }
    }

    suspend fun createOrder(createOrderRequest: CreateOrderRequest): ApiResult<OrderResultResponse> {
        return try {
            val productIdRequestBody =
                createOrderRequest.productId.toRequestBody("text/plain".toMediaTypeOrNull())
            val optionId =
                createOrderRequest.optionId.toRequestBody("text/plain".toMediaTypeOrNull())
            val methodId =
                createOrderRequest.methodId.toRequestBody("text/plain".toMediaTypeOrNull())
            val gameId = createOrderRequest.gameId.toRequestBody("text/plain".toMediaTypeOrNull())
            val server = createOrderRequest.server.toRequestBody("text/plain".toMediaTypeOrNull())

            val response = mUserService.createOrder(
                productId = productIdRequestBody,
                optionId = optionId,
                methodId = methodId,
                gameId = gameId,
                server = server
            )

            Log.d("checkResultOrder", "createOrder: $response ")
            if (response.success) ApiResult.Success(response.data) else ApiResult.Error(response.message)

        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.parseError()
            ApiResult.Error(errorBody?.message ?: "Unknown error")
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Network error")
        }
    }

    suspend fun logout(): ApiResult<Unit> = runCatching {
        val response = mUserService.logout()
        if (response.success) {
            mAuthPreferences.clearToken()
            ApiResult.Success(response.data)
        } else {
            ApiResult.Error(response.message)
        }
    }.getOrElse { e ->
        val message = when (e) {
            is HttpException -> e.response()?.errorBody()?.parseError()?.message ?: "Unknown error"
            else -> e.message ?: "Network error"
        }
        ApiResult.Error(message)
    }
}