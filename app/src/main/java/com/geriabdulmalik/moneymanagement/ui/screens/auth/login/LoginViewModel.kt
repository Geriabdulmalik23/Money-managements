package com.geriabdulmalik.moneymanagement.ui.screens.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geriabdulmalik.moneymanagement.data.model.BodyResponse
import com.geriabdulmalik.moneymanagement.data.repository.AuthRepository
import com.geriabdulmalik.moneymanagement.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val mAuthRepository: AuthRepository) :
    ViewModel() {

    private val _resultState = MutableStateFlow<ResultState<BodyResponse>>(ResultState.Idle)
    val resultState: StateFlow<ResultState<BodyResponse>> = _resultState.asStateFlow()


    fun login(email: String, password: String) {
        viewModelScope.launch {
            _resultState.emit(ResultState.Loading)
            try {
                when (val result = mAuthRepository.authLogin(email = email, password = password)) {
                    is ApiResult.Success -> _resultState.emit(ResultState.Success(result.data))
                    is ApiResult.Error -> _resultState.emit(ResultState.Error(result.message))
                    else -> _resultState.emit(ResultState.Idle)
                }
            } catch (e: Exception) {
                _resultState.emit(ResultState.Error(e.message ?: "Login failed"))
            }
        }
    }
}