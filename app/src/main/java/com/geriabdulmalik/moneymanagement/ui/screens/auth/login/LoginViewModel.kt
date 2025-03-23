package com.geriabdulmalik.moneymanagement.ui.screens.auth.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geriabdulmalik.moneymanagement.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val mAuthRepository: AuthRepository) :
    ViewModel() {

    private val _resultState = MutableStateFlow<ResultState>(ResultState.Idle)
    val resultState: StateFlow<ResultState> = _resultState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _resultState.emit(ResultState.Loading) // Gunakan emit() karena StateFlow adalah Flow
            try {
                val response = mAuthRepository.authLogin(email, password)

                if (response.status) {
                    _resultState.emit(ResultState.Success(response))
                } else {
                    _resultState.emit(ResultState.Error(response.message))
                }
            } catch (e: Exception) {
                _resultState.emit(ResultState.Error(e.message ?: "Login failed"))
            }
        }
    }
}