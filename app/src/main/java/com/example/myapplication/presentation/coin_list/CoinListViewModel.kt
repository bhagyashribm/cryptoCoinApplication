package com.example.myapplication.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.Constants
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {

        savedStateHandle.get<String>(Constants.PARAM_ASSET)
            ?.let {
                getCoin("BTC", "1591270250816523617", "4b224e832e0edaf859ab9f757264450a")
                }


    }

    private fun getCoin(asset: String ,nonce :String , apikey:String) {
        getCoinsUseCase(asset,nonce ,apikey ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}