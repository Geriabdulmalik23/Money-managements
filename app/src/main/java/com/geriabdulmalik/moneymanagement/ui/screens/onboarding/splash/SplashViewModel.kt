package com.geriabdulmalik.moneymanagement.ui.screens.onboarding.splash

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
class SplashViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    private val _token = MutableStateFlow<String?>(null) // StateFlow untuk token
    val token: StateFlow<String?> = _token.asStateFlow()

    init {
        viewModelScope.launch {
            authRepository.getToken().collect { savedToken ->
                _token.value = savedToken // Update token dari DataStore
            }
        }
    }
}