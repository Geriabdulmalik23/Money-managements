package com.geriabdulmalik.moneymanagement.ui.screens.order

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geriabdulmalik.moneymanagement.data.model.CheckPriceResponse
import com.geriabdulmalik.moneymanagement.data.model.CreateOrderRequest
import com.geriabdulmalik.moneymanagement.data.model.HomeResponse
import com.geriabdulmalik.moneymanagement.data.model.OrderResultResponse
import com.geriabdulmalik.moneymanagement.data.model.PaymentMethodResponse
import com.geriabdulmalik.moneymanagement.data.model.ProductItemResponse
import com.geriabdulmalik.moneymanagement.data.repository.UserRepository
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.ResultState
import com.geriabdulmalik.moneymanagement.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle, private val mUserRepository: UserRepository
) : ViewModel() {

    private val _mProductItem =
        MutableStateFlow<ResultState<List<ProductItemResponse>>>(ResultState.Idle)
    val mProductItem: StateFlow<ResultState<List<ProductItemResponse>>> = _mProductItem

    private val _mPaymentMethod =
        MutableStateFlow<ResultState<List<PaymentMethodResponse>>>(ResultState.Idle)
    val mPaymentMethod: StateFlow<ResultState<List<PaymentMethodResponse>>> = _mPaymentMethod

    private val _mCheckPrice = MutableStateFlow<ResultState<CheckPriceResponse>>(ResultState.Idle)
    val mCheckPrice: StateFlow<ResultState<CheckPriceResponse>> = _mCheckPrice

    private val _mOrderResult = MutableStateFlow<ResultState<OrderResultResponse>>(ResultState.Idle)
    val mOrderResult: StateFlow<ResultState<OrderResultResponse>> = _mOrderResult

    private val productId: String = savedStateHandle["productId"] ?: ""

    private fun fetchProductItem() {

        viewModelScope.launch {
            _mProductItem.emit(ResultState.Loading)
            try {
                when (val result = mUserRepository.getProductItem(productId = productId.toInt())) {
                    is ApiResult.Success -> _mProductItem.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _mProductItem.emit(ResultState.Error(result.message))
                    else -> Unit
                }
            } catch (exception: Exception) {
                _mProductItem.emit(ResultState.Error(exception.message ?: "Data failed"))
            }
        }
    }

    private fun fetchPaymentMethod() {
        viewModelScope.launch {
            _mPaymentMethod.emit(ResultState.Loading)
            try {
                when (val result = mUserRepository.getPaymentMethod()) {
                    is ApiResult.Success -> _mPaymentMethod.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _mPaymentMethod.emit(ResultState.Error(result.message))
                    else -> Unit
                }
            } catch (exception: Exception) {
                _mPaymentMethod.emit(ResultState.Error(exception.message ?: "Data failed"))
            }
        }
    }

    fun checkPrice(itemId: Int) {
        viewModelScope.launch {
            _mCheckPrice.emit(ResultState.Loading)
            try {
                when (val result = mUserRepository.checkPrice(itemId = itemId)) {
                    is ApiResult.Success -> _mCheckPrice.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _mCheckPrice.emit(ResultState.Error(result.message))
                    else -> Unit
                }
            } catch (exception: Exception) {
                _mCheckPrice.emit(ResultState.Error(exception.message ?: "Data failed"))
            }
        }
    }

    fun createOrder(orderRequest: CreateOrderRequest) {
        viewModelScope.launch {
            _mOrderResult.emit(ResultState.Loading)
            try {
                when (val result = mUserRepository.createOrder(createOrderRequest = orderRequest)) {
                    is ApiResult.Success -> _mOrderResult.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _mOrderResult.emit(ResultState.Error(result.message))
                    else -> Unit
                }
            } catch (exception: Exception) {
                _mOrderResult.emit(ResultState.Error(exception.message ?: "Data failed"))
            }
        }
    }

    init {
        fetchProductItem()
        fetchPaymentMethod()
    }
}