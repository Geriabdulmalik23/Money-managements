package com.geriabdulmalik.moneymanagement.ui.screens.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geriabdulmalik.moneymanagement.data.model.HomeResponse
import com.geriabdulmalik.moneymanagement.data.model.ProductResponse
import com.geriabdulmalik.moneymanagement.data.repository.UserRepository
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.ResultState
import com.geriabdulmalik.moneymanagement.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val mUserRepository: UserRepository) : ViewModel() {

    private val _mProduct = MutableStateFlow<ResultState<HomeResponse>>(ResultState.Idle)
    val mProduct: StateFlow<ResultState<HomeResponse>> = _mProduct

    private fun fetchProduct() {
        viewModelScope.launch {
            _mProduct.emit(ResultState.Loading)
            try {
                when (val result = mUserRepository.getProduct()) {
                    is ApiResult.Success -> _mProduct.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _mProduct.emit(ResultState.Error(result.message))
                    else -> Unit
                }
            } catch (exception: Exception) {
                _mProduct.emit(ResultState.Error(exception.message ?: "Data failed"))
            }
        }
    }

    init {
        fetchProduct()
    }
}