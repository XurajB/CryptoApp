package com.iandrobot.cryptoapp6.presentation.coin_list.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iandrobot.cryptoapp6.common.Resource
import com.iandrobot.cryptoapp6.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val useCase: GetCoinsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CoinListState())
    val state: StateFlow<CoinListState> = _state

    init {
        viewModelScope.launch {
            useCase().collect { resource ->
                when (resource) {
                    is Resource.Error -> {
                        _state.value = CoinListState(error = resource.message ?: "Error")
                    }
                    is Resource.Loading -> {
                        _state.value = CoinListState(isLoading = true)
                    }
                    is Resource.Success -> {
                        _state.value = CoinListState(coins = resource.data ?: emptyList())
                    }
                }
            }
        }
    }
}