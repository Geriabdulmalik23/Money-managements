package com.geriabdulmalik.moneymanagement.ui.screens.auth.login

import androidx.compose.runtime.Composable
import com.geriabdulmalik.moneymanagement.data.model.AuthResponse

sealed class ResultState<out T> {
    object Idle : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val message: String) : ResultState<Nothing>()
}

@Composable
inline fun <T> ResultState<T>.handle(
    crossinline onLoading: @Composable () -> Unit = {},
    crossinline onSuccess: @Composable (T) -> Unit,
    crossinline onError: @Composable (String) -> Unit = {},
    crossinline onIdle: @Composable () -> Unit = {}
) {
    when (this) {
        is ResultState.Idle -> onIdle()
        is ResultState.Loading -> onLoading()
        is ResultState.Success -> onSuccess(data)
        is ResultState.Error -> onError(message)
    }
}