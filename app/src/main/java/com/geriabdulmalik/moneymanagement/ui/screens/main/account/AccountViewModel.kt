package com.geriabdulmalik.moneymanagement.ui.screens.main.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geriabdulmalik.moneymanagement.data.model.UserResponse
import com.geriabdulmalik.moneymanagement.data.repository.UserRepository
import com.geriabdulmalik.moneymanagement.ui.screens.auth.login.ResultState
import com.geriabdulmalik.moneymanagement.utils.ApiResult
import com.geriabdulmalik.moneymanagement.utils.BaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(private val mUserRepository: UserRepository) :
    ViewModel() {

    private val _mUserData = MutableStateFlow<ResultState<UserResponse>>(ResultState.Idle)
    val mUserData: StateFlow<ResultState<UserResponse>> = _mUserData

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading = _isLoading

    private val _mLogout = MutableStateFlow<ResultState<Unit>>(ResultState.Idle)
    val logoutState: StateFlow<ResultState<Unit>> = _mLogout


    private fun getProfile() {
        viewModelScope.launch {
            _mUserData.emit(ResultState.Loading)
            try {
                when (val result = mUserRepository.getProfile()) {
                    is ApiResult.Success -> _mUserData.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _mUserData.emit(ResultState.Error(result.message))
                    else -> Unit
                }
            } catch (exception: Exception) {
                _mUserData.emit(ResultState.Error(exception.message ?: "Data failed"))
            }
        }
    }


    fun logout() {
        viewModelScope.launch {
            try {
                when (val result = mUserRepository.logout()) {
                    is ApiResult.Success -> _mLogout.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _mLogout.emit(ResultState.Error(result.message))
                    else -> Unit
                }
            } catch (exception: Exception) {
                _mLogout.emit(ResultState.Error(exception.message ?: "Data failed"))
            }
        }
    }

    init {
        getProfile()
    }

}