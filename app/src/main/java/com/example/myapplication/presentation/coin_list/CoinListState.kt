package com.example.myapplication.presentation.coin_list

import com.example.myapplication.domain.model.CoinDtails


data class CoinListState(
    val isLoading: Boolean = false,
    val coins: CoinDtails? = null,
    val error: String = ""
)
