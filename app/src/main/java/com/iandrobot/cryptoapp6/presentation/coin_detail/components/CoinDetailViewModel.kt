package com.iandrobot.cryptoapp6.presentation.coin_detail.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iandrobot.cryptoapp6.common.Constants
import com.iandrobot.cryptoapp6.common.Resource
import com.iandrobot.cryptoapp6.domain.use_case.GetCoinsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val useCase: GetCoinsByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val coinDetailState: State<CoinDetailState> = _coinDetailState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoinDetail(it)
        }
    }

    private fun getCoinDetail(coinId: String) {
        viewModelScope.launch {
            useCase(coinId).collect { resource ->
                when (resource) {
                    is Resource.Error -> {
                        _coinDetailState.value = CoinDetailState(error = resource.message ?: "Error")
                    }
                    is Resource.Loading -> {
                        _coinDetailState.value = CoinDetailState(loading = true)
                    }
                    is Resource.Success -> {
                        _coinDetailState.value = CoinDetailState(coinDetail = resource.data)
                    }
                }
            }
        }
    }
}