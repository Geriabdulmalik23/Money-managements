package com.geriabdulmalik.moneymanagement.ui.screens.auth.login

import com.geriabdulmalik.moneymanagement.data.model.AuthResponse

sealed class ResultState {
    object Idle : ResultState()
    object Loading : ResultState()
    data class Success(val data: AuthResponse) : ResultState()
    data class Error(val message: String) : ResultState()
}
